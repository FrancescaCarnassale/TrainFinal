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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beans.Trip;
import com.manager.TripManager;
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
		return "ricercaTreno/ricercaTreno";
	}
	
	@RequestMapping(path = {"/buy"}, method= {RequestMethod.GET,RequestMethod.POST})
	public String buy(HttpServletRequest request, @WebParam String tripId){
		//CARICA LA NUOVA PAGINA OVE L'UTENTE COMPRA IL BIGLIETTO
		return "ricercaTreno/ricercaTreno";
	}
}
