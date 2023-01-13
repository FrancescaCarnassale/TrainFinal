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

import com.User.exceptions.UserNotFound;
import com.beans.Alias;
import com.beans.Login;
import com.beans.User;
import com.dao.impl.AliasDaoImpl;
import com.manager.UserManager;
import com.manager.strategy.StrategyDB;

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
		//StrategyDB s = new StrategyDB();
		UserManager us = new UserManager();
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		RequestDispatcher dispatcher;
		
		String msg = "";
			//bean login oppure bean user
			Login login = new Login();
			login.setEmail(email);
			login.setPassword(password);
			User user = us.getUser(login);
			String error = "L'utente inserito non è stato trovato!";
			if(user != null) {
				msg = "Benvenuto "+ user.getName()+"!";
				request.setAttribute("user", user.getName());
				//vanno segnate informazioni sulla sessione
				request.setAttribute("msg", msg);
				dispatcher = getServletContext().getRequestDispatcher("/registrazioneLogin/welcome.jsp");
			}else{
				msg="login non riuscita";
				request.setAttribute("msg", msg);
				dispatcher = getServletContext().getRequestDispatcher("/registrazioneLogin/login.jsp");
			}
	
		dispatcher.forward(request, response);
	}

}
