package com.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beans.Reservation;
import com.beans.Trip;
import com.manager.ReservationManager;
import com.manager.TripManager;
import com.manager.UserManager;
import com.manager.strategy.StrategyDB;

@Controller
@RequestMapping(value = "/buyingTickets")
public class BuyingTicketController {
	
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
	
	@RequestMapping(path = {"/buyingPage"}, method= {RequestMethod.GET,RequestMethod.POST})
	public String buyingPage(HttpServletRequest request, @WebParam int tripId){
		//CARICA LA NUOVA PAGINA OVE L'UTENTE COMPRA IL BIGLIETTO
		TripManager tripManager= new TripManager();
		request.setAttribute("tripId", tripManager.getTripDao().get(tripId));
		int msg=tripId;
		request.setAttribute("msg", msg);
		return "ricercaTrip/acquistoBiglietto";
	}
	
	@RequestMapping(path = {"/buy"}, method= {RequestMethod.GET,RequestMethod.POST})
	public String buy(HttpServletRequest request, @WebParam int tripId, @WebParam int seats){
		//CARICA LA NUOVA PAGINA OVE L'UTENTE COMPRA IL BIGLIETTO
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
