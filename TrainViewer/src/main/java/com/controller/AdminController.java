package com.controller;

import javax.jws.WebParam;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.manager.strategy.StrategyDB;

@Controller
@RequestMapping(value = "/aliasApproving", method = RequestMethod.GET)
public class AdminController {
	
	@GetMapping("/approve")
	public String approve(HttpServletRequest request, @WebParam String[] checkAlias, 
			@WebParam String[] checkDelete, @WebParam String[] newCountry){
		//String input = request.getParameter("input"); 
		StrategyDB s = new StrategyDB();
		s.approveAndCancelAlias(checkAlias, checkDelete, newCountry);
		String msg = "Operazione avvenuta con successo!";
		request.setAttribute("msg", msg);
		return "admin";
	}
	
}
