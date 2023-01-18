package com.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ChainResponsibility.CheckChain;
import com.beans.Alias;
import com.beans.Country;
import com.beans.Train;
import com.beans.Trip;
import com.dao.TripDao;
import com.dao.impl.TripDaoImpl;
import com.manager.AliasManager;
import com.manager.TripManager;
import com.manager.strategy.Strategy;
import com.manager.strategy.StrategyDB;
@WebServlet("/CreazioneTripServlet")
public class CreazioneTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CreazioneTripServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = null;
		response.setContentType("text/html");
		StrategyDB s = new StrategyDB();
		AliasManager aliasManager = new AliasManager();
		TripManager tr = new TripManager();
		int idTrain = Integer.valueOf(request.getParameter("idTrain"));
		String departure = request.getParameter("departure");
		String arrive = request.getParameter("arrive");
		SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date dateStart = null;
		Date dateEnd = null;
		try {
			dateStart = isoFormat.parse(request.getParameter("start"));
			dateEnd = isoFormat.parse(request.getParameter("end"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp timeStart = new Timestamp(dateStart.getTime());
		Timestamp timeEnd = new Timestamp(dateEnd.getTime());
		Map<String, List<String>> map = s.dataMap();
		CheckChain checkChain=s.getChain();
		String partenza= checkChain.check(departure);
		String arrivo= checkChain.check(arrive);
		TripDaoImpl td = (TripDaoImpl)tr.getTripDao();
		if(partenza!=null) {
			if(arrivo!=null) {
				Trip trip= new Trip();  
				Train tp= td.getSession().get(Train.class,idTrain);
				trip.setArrive(td.getSession().get(Country.class,arrive));         
				trip.setDeparture(td.getSession().get(Country.class,departure));         
				trip.setIdTrain(tp);         
				trip.setTimeArrive(timeEnd);         
				trip.setTimeDeparture(timeStart);
				trip.setSeatsAvailable(tp.getSeats());
				tr.setTrip(trip);
				//I DATI SONO TUTTI CORRETTI
				msg = "idTrain: " + idTrain+ " Departure: "+partenza + " Arrive: "+ arrivo
						+" TimeDeparture: "+timeStart+" TimeArrrive: "+timeEnd + " Seats avaiable: " +tp.getSeats();
			}
			else {
				Alias a= new Alias();
				a.setAlias(arrive);
				a.setCountry(null);
				a.setApproved(false);
				aliasManager.setAlias(a);
				msg = "Arrivo non trovato!";
			}
		}
		else {
			Alias a= new Alias();
			a.setAlias(departure);
			a.setCountry(null);
			a.setApproved(false);
			aliasManager.setAlias(a);
			msg = "Partenza non trovata!";
		}
		
		// CREAZIONE TRENO CORRETTO
		request.setAttribute("msg", msg);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/creazioneTripAdmin/creazioneTrip.jsp");
		dispatcher.forward(request, response);
	}
}