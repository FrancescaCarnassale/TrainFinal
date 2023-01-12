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
import com.strategy.Strategy;
import com.strategy.StrategyDB;
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
		if(partenza!=null) {
			if(arrivo!=null) {
				s.setTrip(idTrain, departure, arrive, timeStart, timeEnd);
				//I DATI SONO TUTTI CORRETTI
				msg = "idTrain: " + idTrain+ " Departure: "+partenza + " Arrive: "+ arrivo
						+" TimeDeparture: "+timeStart+" TimeArrrive: "+timeEnd;
			}
			else {
				s.addAliasUnknown(arrive);
				msg = "Arrivo non trovato!";
			}
		}
		else {
			s.addAliasUnknown(departure);
			msg = "Partenza non trovata!";
		}
		
		// CREAZIONE TRENO CORRETTO
		request.setAttribute("msg", msg);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/creazioneTripAdmin/creazioneTrip.jsp");
		dispatcher.forward(request, response);
	}
}
