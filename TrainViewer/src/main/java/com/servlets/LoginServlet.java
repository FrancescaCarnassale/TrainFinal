package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Login;
import com.beans.User;
import com.manager.UserManager;


/**
 * 
 * The servlet will pass the data from login.jsp to the controllers, to manage data for the db
 *
 */

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

		UserManager us = new UserManager();
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		RequestDispatcher dispatcher;
		
        HttpSession session = request.getSession();     
		String msg = "";
			//bean login oppure bean user
			Login login = new Login();
			login.setEmail(email);
			login.setPassword(password);
			User user = us.getUser(login);
			if(user != null) {
				msg = "Benvenuto "+ user.getName()+"!";
				request.setAttribute("user", user.getName());
				request.setAttribute("role", user.getRole());
				request.setAttribute("msg", msg);
				
				session.setAttribute("user", user.getName());
				session.setAttribute("role", user.getRole());
				session.setAttribute("email", user.getEmail());
				
				dispatcher = getServletContext().getRequestDispatcher("/");
			}else{
				msg="Email o password errati";
				request.setAttribute("msg", msg);
				dispatcher = getServletContext().getRequestDispatcher("/registrazioneLogin/login.jsp");
			}
	
		dispatcher.forward(request, response);
	}

}
