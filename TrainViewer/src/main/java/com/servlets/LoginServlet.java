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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		StrategyDB s = new StrategyDB();
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		RequestDispatcher dispatcher;
		String user = s.getUser(email, password);
		if(user != "") {
			request.setAttribute("user", user);
			dispatcher = getServletContext().getRequestDispatcher("/registrazioneLogin/welcome.jsp");
		} else {
			dispatcher = getServletContext().getRequestDispatcher("/registrazioneLogin/login.jsp");
		}

		dispatcher.forward(request, response);
	}

}
