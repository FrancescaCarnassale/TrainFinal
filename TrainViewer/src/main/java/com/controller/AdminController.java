package com.controller;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.manager.strategy.StrategyDB;
/**
 * Controller of the admin.jsp page
 */
@Controller
@RequestMapping(value = "/aliasApproving", method = RequestMethod.GET)
public class AdminController {
	
	/**
	 * The /approve controller approves or deletes the list of aliases selected by the admin.
	 * @param request 
	 * @param checkAlias: Array of elements of which we want to approve
	 * @param checkDelete: Array of elements of which we want to delete
	 * @param newCountry: Array of elements that have to be assigned to the new aliases that we are approving
	 * @return page we want to load afterwards
	 */
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
