package com.controller;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beans.Leaderboard;
import com.beans.User;
import com.dao.impl.UserDaoImpl;
import com.manager.strategy.StrategyDB;

@Controller
@RequestMapping(value = "/leaderboardController")
public class LeaderboardController {
	
	@ResponseBody
	@RequestMapping( 
			path={"/updateScore"},
			method= { RequestMethod.POST, RequestMethod.GET}
	)
	//nome parametro e id devono coincidere
	public String updateScore(HttpServletRequest request,HttpServletResponse httpServletResponse, @WebParam String punteggio){
		
		UserDaoImpl userdao = new UserDaoImpl();
		StrategyDB s = new StrategyDB();
		Leaderboard l = null;
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("email");
		System.out.println("stampo utente " + user + " e punteggio " + punteggio);
		User u = userdao.get(user);
		String punteggio2 = "10";
		
		//recupero il punteggio precedente di utente
		l = s.getOldScore(u);
		
		if(l ==  null ) {
			l = new Leaderboard();
			l.setScore(0);
		}
		
		//se il punteggio precedente e' minore di quello attuale aggiorno
		if(l.getScore() < Integer.valueOf(punteggio)) {
			l.setUser(u);
			l.setScore(Integer.valueOf(punteggio));
			s.updateScore(l);
		}
		httpServletResponse.setHeader("Location", "/TrainViewer/trainGame/Game.jsp");
	    httpServletResponse.setStatus(302);
		
		return "";
	}
	
}