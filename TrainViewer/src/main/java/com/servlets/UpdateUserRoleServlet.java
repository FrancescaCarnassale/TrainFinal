package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Alias;
import com.dao.impl.AliasDaoImpl;
import com.manager.strategy.StrategyDB;

@WebServlet("/UpdateUserRoleServlet")
public class UpdateUserRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateUserRoleServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		StrategyDB s = new StrategyDB();
		String msg = null;
		String[] checkRoles = request.getParameterValues("checkRole");
		String[] newRoles = request.getParameterValues("newRole");
		s.updateUserRole(checkRoles, newRoles);
		msg = "Ruoli assegnati";
		request.setAttribute("msg", msg);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updateUserRole.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
