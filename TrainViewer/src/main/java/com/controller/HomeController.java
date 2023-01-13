package com.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(path={"/","/web"})
public class HomeController {
	
	/**
	 * esempi di url:
	 * http://localhost:8080/CorsoSpringWeb/index
	 * http://localhost:8080/CorsoSpringWeb/home
	 * */

	
	/**
	 * esempi di url: 
	 * http://localhost:8080/CorsoSpringWeb/get?nome=Mario&cognome=Rossi
	 * oppure:
	 * http://localhost:8080/CorsoSpringWeb/post?nome=Mario&cognome=Rossi
	 * 
	 * il metodo viene eseguito solo in presenza dei due parametri con lo stesso valore. 
	 * 
	 */
	@ResponseBody
	@RequestMapping( 
			path={"/get", "/post"},
			method= {RequestMethod.GET, RequestMethod.POST},
			params = {"nome=Mario", "cognome=Rossi"}
	)
	public String provaGEToPOST () {
		return "Contenuto per la richiesta di Mario Rossi...";
	}

	/**
	 * esempi di url: 
	 * http://localhost:8080/CorsoSpringWeb/get?nome=Mario&cognome=Rossi
	 * oppure:
	 * http://localhost:8080/CorsoSpringWeb/post?nome=Mario&cognome=Rossi
	 * 
	 * il metodo viene eseguito solo in presenza dei due parametri con lo stesso valore. 
	 * 
	 */
	@ResponseBody
	@RequestMapping(
			path={"/get", "/post"},
			method= {RequestMethod.GET, RequestMethod.POST},
			params = {"nome!=Mario", "cognome!=Rossi"}
	)
	public String provaGEToPOSTNot () {
		return "Contenuto per la richiesta ...";
	}	
	
	

		
	
}
