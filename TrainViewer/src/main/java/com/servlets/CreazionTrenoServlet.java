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
import com.TrenoFactory.exceptions.TrenoException;
import com.TrenoFactory.factory.FRFactory;
import com.TrenoFactory.factory.TNFactory;
import com.TrenoFactory.factory.VagoneFactory;
import com.TrenoFactory.treno.Treno;
import com.beans.Train;
import com.manager.TrainManager;

/**
 * 
 * The servlet will pass the data from creazioneTreno.jsp to the controllers, to manage data for the db
 *
 */

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
		//Based on user input, will be user one factory over the other one
		if(produttore.equals("Frecciarossa"))
			vagoneFactory = new FRFactory();
		else
			vagoneFactory = new TNFactory();
		
		
		TrenoBuilder builder = new ConcreteBuilder(vagoneFactory);
		Treno t;	
		Train train = new Train();
		
		String msg;
			try {
				//the builder will check if all che parameters for the train are respected
				t = builder.buildTreno(serialNumber.toUpperCase());
				//building train instance
				train.setBrand(produttore);
				train.setSerialNumber(serialNumber);
				train.setSeats(t.getNumPosti());
				s.setTrain(train);
				msg = "Operazione avvenuta con successo! "+
				"Hai creato il treno "+ produttore+ " con numero seriale: "+
						serialNumber;
			} catch ( TrenoException | IllegalArgumentException e) {
				//if the input is wrong, exceptions will be throw
				msg=e.getMessage();
			} 
			
		request.setAttribute("msg", msg);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/creazioneTrenoAdmin/creazioneTreno.jsp");
		dispatcher.forward(request, response);
	}
}





