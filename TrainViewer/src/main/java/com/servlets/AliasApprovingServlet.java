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

@WebServlet("/AliasApprovingServlet")
public class AliasApprovingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AliasApprovingServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		StrategyDB s = new StrategyDB();
		String[] checkAliases = request.getParameterValues("checkAlias");
		String[] deleteAliases = request.getParameterValues("checkDelete");
		if(checkAliases!=null)
			s.approveAlias(checkAliases);
		if(deleteAliases!=null)
			s.cancelAlias(deleteAliases);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
