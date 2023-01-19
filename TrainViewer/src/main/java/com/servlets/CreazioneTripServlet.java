package com.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.dao.impl.TripDaoImpl;
import com.manager.AliasManager;
import com.manager.TripManager;
import com.manager.strategy.StrategyDB;

/**
 * 
 * The servlet will pass the data from creazioneTrip.jsp to the controllers, to manage data for the db
 *
 */

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
		
		//getting data from jsp
		int idTrain = Integer.valueOf(request.getParameter("idTrain"));
		String departure = request.getParameter("departure");
		String arrive = request.getParameter("arrive");
		
		//converting input into Timestamp
		SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date dateStart = null;
		Date dateEnd = null;
		try {
			dateStart = isoFormat.parse(request.getParameter("start"));
			dateEnd = isoFormat.parse(request.getParameter("end"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Timestamp timeStart = new Timestamp(dateStart.getTime());
		Timestamp timeEnd = new Timestamp(dateEnd.getTime());
		
		//getting chain for check the input string following the chain of responsability pattern 
		CheckChain checkChain=s.getChain();
		//checking if from the input we retrive an official country
		String partenza= checkChain.check(departure);
		String arrivo= checkChain.check(arrive);
		TripDaoImpl td = (TripDaoImpl)tr.getTripDao();
		
		//if partenza!=null the check has found the related country
		if(partenza!=null) {
			//if arrivo!=null the check has found the related country
			if(arrivo!=null) {
				Trip trip= new Trip();  
				partenza = partenza.substring(0, 1).toUpperCase() + partenza.substring(1);
				arrivo = arrivo.substring(0, 1).toUpperCase() + arrivo.substring(1);
				Train tp= td.getSession().get(Train.class,idTrain);
				trip.setArrive(td.getSession().get(Country.class,arrivo));         
				trip.setDeparture(td.getSession().get(Country.class,partenza));         
				trip.setIdTrain(tp);         
				trip.setTimeArrive(timeEnd);         
				trip.setTimeDeparture(timeStart);
				trip.setSeatsAvailable(tp.getSeats());
				tr.setTrip(trip);
				//I DATI SONO TUTTI CORRETTI
				msg = "Hai creato il trip! Ecco un resoconto dei dati:\n"+
				"idTrain:" + idTrain+ " Partenza: "+partenza + " Arrivo: "+ arrivo
						+" orario di partenza: "+timeStart+" orario di arrivo: "+timeEnd + " Posti disponibili: " +tp.getSeats();
			}
			//arrivo has no correspondence
			else {
				Alias a= new Alias();
				a.setAlias(arrive);
				a.setCountry(null);
				a.setApproved(false);
				aliasManager.setAlias(a);
				msg = "Arrivo non trovato!";
			}
		}
		//partenza has no correspondence
		else {
			Alias a= new Alias();
			a.setAlias(departure);
			a.setCountry(null);
			a.setApproved(false);
			aliasManager.setAlias(a);
			msg = "Partenza non trovata!";
		}
		request.setAttribute("msg", msg);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/creazioneTripAdmin/creazioneTrip.jsp");
		dispatcher.forward(request, response);
	}
}