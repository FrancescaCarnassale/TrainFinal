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
import com.strategy.StrategyDB;

@WebServlet("/RegistrazioneServlet")
public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegistrazioneServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Funzionaaaaaaaaaaaaaaaaa?????????????????????");
		response.setContentType("text/html");
		StrategyDB s = new StrategyDB();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		s.setUser(name, password, email);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("../registrazione.jsp");
		dispatcher.forward(request, response);
	}

}
