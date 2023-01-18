package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Login;
import com.beans.User;
import com.manager.UserManager;

/**
 * 
 * The servlet will pass the data from registrazione.jsp to the controllers, to manage data for the db
 *
 */

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

		//creation of the user object with the input parameter that will be use to create the record in the DB
		User u = new User();
		String name = request.getParameter("name");
		u.setName(name);
		String email = request.getParameter("email");
		u.setEmail(email);
		
		String password = request.getParameter("password");
		u.setPassword(password);
		u.setRole("client");
		
		Login check = new Login();
		
		check.setEmail(email); 
		check.setPassword(password);
		
		RequestDispatcher dispatcher;
		
		//check if the user already exists. If not, new user will be added in the DB and will be displayed a successful message. 
		//Otherwise an error message will be displayed
	
		if(s.getUser(check)== null) {
			s.setUser(u);
			request.setAttribute("msg", "Utente creato con successo!");
			 dispatcher = getServletContext().getRequestDispatcher("/registrazioneLogin/login.jsp");
		}else {
			request.setAttribute("msg", "Utente esistente!");
			 dispatcher = getServletContext().getRequestDispatcher("/registrazioneLogin/registrazione.jsp");
		}
		
		
		
		dispatcher.forward(request, response);
	}

}
