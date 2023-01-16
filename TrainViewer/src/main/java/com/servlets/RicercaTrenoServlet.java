package com.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
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
import com.ChainResponsibility.algorithm.Contained;
import com.ChainResponsibility.algorithm.Contains;
import com.ChainResponsibility.algorithm.ContainsPartial;
import com.ChainResponsibility.algorithm.EqualsInputCS;
import com.ChainResponsibility.algorithm.EqualsStandardCS;
import com.ChainResponsibility.algorithm.JaroDistance;
import com.ChainResponsibility.algorithm.Levenshtein;
import com.TrenoFactory.builder.ConcreteBuilder;
import com.TrenoFactory.builder.TrenoBuilder;
import com.TrenoFactory.exceptions.NumeroPostiInEccesso;
import com.TrenoFactory.exceptions.TrenoException;
import com.TrenoFactory.factory.FRFactory;
import com.TrenoFactory.factory.TNFactory;
import com.TrenoFactory.factory.VagoneFactory;
import com.TrenoFactory.treno.Treno;
import com.beans.Country;
import com.beans.Trip;
import com.strategy.Strategy;
import com.strategy.StrategyDB;
@WebServlet("/RicercaTrenoServlet")
public class RicercaTrenoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RicercaTrenoServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		StrategyDB s = new StrategyDB();
		String departure = request.getParameter("departureSelected");
		String arrive = request.getParameter("arriveSelected");
		SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date timeDeparture = null;
		try {
			timeDeparture = isoFormat.parse(request.getParameter("timeDeparture"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp departureTime = new Timestamp(timeDeparture.getTime());
		Country departureCountry = new Country();
		departureCountry.setCountryName(departure);
		Country arriveCountry = new Country();
		arriveCountry.setCountryName(arrive);
		Collection<Trip> trips = s.getTrips(departureCountry, arriveCountry, departureTime);
		
		request.setAttribute("trips", trips);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ricercaTreno/ricercaTreno.jsp");
		dispatcher.forward(request, response);
	}
}