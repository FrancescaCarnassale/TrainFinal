package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.strategy.StrategyDB;

/**
 * 
 * The servlet will pass the data from updateUserRole.jsp to the controllers, to manage data for the db
 *
 */

@WebServlet("/UpdateUserRoleServlet")
public class UpdateUserRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateUserRoleServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		StrategyDB s = new StrategyDB();
		//Array of all users selected from the updateUserRole.jsp
		String[] checkRoles = request.getParameterValues("checkRole");
		//Array of all users selected from the updateUserRole.jsp
		String[] newRoles = request.getParameterValues("newRole");
		//Method update all users in the array with relative new role
		s.updateUserRole(checkRoles, newRoles);
		
		request.setAttribute("msg", "Ruoli assegnati correttamente");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updateUserRole.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
