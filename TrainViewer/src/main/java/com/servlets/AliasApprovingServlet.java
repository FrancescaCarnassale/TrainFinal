package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.strategy.StrategyDB;

@WebServlet("/AliasApprovingServlet")

/**
 * 
 * The servlet will pass the data from admin.jsp to the controllers, to manage data for the db
 *
 */

public class AliasApprovingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AliasApprovingServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		StrategyDB s = new StrategyDB();
		
		//Array of all aliases selected from the admin.jsp to approve
		String[] checkAliases = request.getParameterValues("checkAlias");
		
		//Array of all aliases selected from the admin.jsp to delete
		String[] deleteAliases = request.getParameterValues("checkDelete");
		
		//Array of all country selected from the admin.jsp to set for the alias
		String[] newCountries = request.getParameterValues("newCountry");
		
		//Method update all aliases in the array with relative new countries and delete
		s.approveAndCancelAlias(checkAliases, deleteAliases, newCountries);
		
		
		String msg = newCountries[0]+" "+newCountries[1];
		request.setAttribute("msg", msg);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
