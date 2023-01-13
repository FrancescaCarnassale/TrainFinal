package com.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest")    // prefisso dei path per tutti i metodi del controller
//@RequestMapping(path={"/", "/altro"}) // si possono impostare pi� path
public class HomeRestController {
	
	@RequestMapping("/home")
	public String home () {
		return "prova";
	}
	
	/**
	 * url: http://localhost:8080/CorsoSpringWeb/rest/produces
	 */
	@ResponseBody
	@RequestMapping(
			path={"/headers", "/produces"},
			method= {RequestMethod.GET, RequestMethod.POST},
			//params = {"nome=Mario", "cognome=Rossi"}, 
			//headers = {"Accept=application/json"},
			//produces = {"application/json"}
			produces  = {MediaType.APPLICATION_JSON_VALUE} 
	)
	public String provaProduces () {
		return "{message:\"Contenuto Json in risposta  alla richiesta!\"}";
	}		
	

	/**
	 * url: http://localhost:8080/CorsoSpringWeb/rest/produces
	 */
	@ResponseBody
	@RequestMapping(
			path={"/headers2", "/produces2"},
			method= {RequestMethod.GET, RequestMethod.POST},
			//params = {"nome=Mario", "cognome=Rossi"}, 
			//headers = {"Accept=application/json"},
			produces = {"application/json"}
			//consumes  = {MediaType.APPLICATION_JSON_VALUE}
			)
	
	public String provaConsumes () {
		return "{message:\"Contenuto Json in risposta  alla richiesta!\"}";
	}
	
	@ResponseBody @GetMapping("/get")	public String provaGet () { return "Prova della get!";}
	@ResponseBody @PostMapping("/post")	public String provaPost () { return "Prova della post!";}
	@ResponseBody @PutMapping("/put")	public String provaPut () { return "Prova della put!";}
	@ResponseBody @DeleteMapping("/delete")	public String provaDelete() { return "Prova della delete!";}
	@ResponseBody @PatchMapping("/patch")	public String provaPatch() { return "Prova della patch!";}
	
	
	
	
	
	
	
	
	
}
