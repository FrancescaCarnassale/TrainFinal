package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TrenoFactory.builder.ConcreteBuilder;
import com.TrenoFactory.builder.TrenoBuilder;
import com.TrenoFactory.exceptions.NumeroPostiInEccesso;
import com.TrenoFactory.exceptions.TrenoException;
import com.TrenoFactory.factory.FRFactory;
import com.TrenoFactory.factory.TNFactory;
import com.TrenoFactory.factory.VagoneFactory;
import com.TrenoFactory.treno.Treno;
import com.beans.Train;
import com.manager.TrainManager;
import com.manager.strategy.StrategyDB;

@WebServlet("/CreazionTrenoServlet")
public class CreazionTrenoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    public CreazionTrenoServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		TrainManager s = new TrainManager();
		String produttore = request.getParameter("produttore");
		String serialNumber = request.getParameter("serialNumber");
		
		//CHECK DATI
		VagoneFactory vagoneFactory;
			//IN BASE AL TIPO DI PRODUTTORE SCELGO QUALE FARE
		if(produttore.equals("Frecciarossa"))
			vagoneFactory = new FRFactory();
		else
			vagoneFactory = new TNFactory();
		
		TrenoBuilder builder = new ConcreteBuilder(vagoneFactory);
		Treno t;	//rimuovere
		Train train = new Train();
		
		String msg;
			try {
				//controllo composizione treno inserito
				t = builder.buildTreno(serialNumber.toUpperCase());
				
				//costruzione istanza treno
				train.setBrand(produttore);
				train.setSerialNumber(serialNumber);
				train.setIsCargo(false);
				s.setTrain(train);
				msg = "Operazione avvenuta con successo!";
			} catch ( TrenoException | IllegalArgumentException /*| NumeroPostiInEccesso */  e) {
				// TODO Auto-generated catch block
				msg=e.getMessage();
			} 
		// CREAZIONE TRENO CORRETTO
		request.setAttribute("msg", msg);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/creazioneTrenoAdmin/creazioneTreno.jsp");
		dispatcher.forward(request, response);
	}
}





