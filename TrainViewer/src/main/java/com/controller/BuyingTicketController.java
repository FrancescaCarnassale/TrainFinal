package com.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.beans.Reservation;
import com.beans.Trip;
import com.manager.ReservationManager;
import com.manager.TripManager;
import com.manager.UserManager;
/**
 * Controller of pages contained in the ricercaTrip folder
 */
@Controller
@RequestMapping(value = "/buyingTickets")
public class BuyingTicketController {
	/**
	 * Given the place of departure, arrival and the time of departure the page shows the trips corresponding to the search.
	 * @param request
	 * @param departures: String of departure
	 * @param arrives: String of arrival
	 * @param timeDeparture: String of timeDeparture
	 * @return same page and updates an html element.
	 */
	@RequestMapping(path = {"/search"}, method= {RequestMethod.GET,RequestMethod.POST})
	public String search(HttpServletRequest request, @WebParam String departures, 
			@WebParam String arrives, @WebParam String timeDeparture){
		TripManager tripManager= new TripManager();
		SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date timeDepartur = null;
		try {
			timeDepartur = isoFormat.parse(timeDeparture);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp departureTime = new Timestamp(timeDepartur.getTime());
		Collection<Trip> trips = tripManager.getTripsWithDate(departures, arrives, departureTime);
		request.setAttribute("trips", trips);
		return "ricercaTrip/ricercaTrip";
	}
	
	/**
	 * When the user chooses the trip, the controller stores the tripId and shows the corresponding trip page 
	 * with all the infos about the trip.
	 * @param request
	 * @param tripId: int corresponding to the id of the Trip
	 * @return page where the user can buy the ticket of the corresponding Trip
	 */
	@RequestMapping(path = {"/buyingPage"}, method= {RequestMethod.GET,RequestMethod.POST})
	public String buyingPage(HttpServletRequest request, @WebParam int tripId){
		//CARICA LA NUOVA PAGINA OVE L'UTENTE COMPRA IL BIGLIETTO
		TripManager tripManager= new TripManager();
		request.setAttribute("tripId", tripManager.getTripDao().get(tripId));
		int msg=tripId;
		request.setAttribute("msg", msg);
		return "ricercaTrip/acquistoBiglietto";
	}
	
	/**
	 * Given the tripId and the number of seats the controller tries to buy the tickets.
	 * If there aren't enough seats available, the string showing on the redirecting page states so and the DB isn't updated.
	 * @param request
	 * @param tripId: int corresponding to the id of the Trip
	 * @param seats: number of seats selected by the user to buy
	 * @return index page
	 */
	@RequestMapping(path = {"/buy"}, method= {RequestMethod.GET,RequestMethod.POST})
	public String buy(HttpServletRequest request, @WebParam int tripId, @WebParam int seats){
		HttpSession session = request.getSession();
		String bought="";
		String email=(String)session.getAttribute("email");
		UserManager userManager= new UserManager();
		TripManager tripManager= new TripManager();
		Trip t= tripManager.getTripDao().get(tripId);
		if(!tripManager.updateSeats(t, seats)) {
			bought="Acquisto non effettuato, il numero di biglietti che desidera "
					+ "acquistare è superiore al numero disponibile per questo viaggio.";
		}
		else {
			Reservation res= new Reservation();
			res.setIdTrip(t);
			res.setNumberTickets(seats);
			res.setUser(userManager.getUserFromEmail(email));
			ReservationManager resManager= new ReservationManager();
			resManager.setReservation(res);
			bought="Acquisto effettuato! Sei in partenza per "+ t.getArrive().getCountryName()+"!";
		}
		request.setAttribute("bought", bought);
		return "index";
	}
}
