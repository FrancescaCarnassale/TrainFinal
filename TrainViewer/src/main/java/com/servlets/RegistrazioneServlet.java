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
import com.beans.User;
import com.dao.impl.AliasDaoImpl;
import com.manager.UserManager;
import com.manager.strategy.StrategyDB;

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
		
		response.setContentType("text/html");
		UserManager s = new UserManager();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String admin= "admin";

		User u = new User();
		u.setName(name);
		u.setEmail(email);
		u.setPassword(password);
		u.setAdmin(admin);
		s.setUser(u);
		request.setAttribute("msg", "Utente creato con successo!");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registrazioneLogin/login.jsp");
		dispatcher.forward(request, response);
	}

}
