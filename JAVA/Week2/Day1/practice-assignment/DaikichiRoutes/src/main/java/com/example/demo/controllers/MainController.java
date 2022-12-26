package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@RequestMapping("/daikichi")
	public String daikichi() {
		return "welcome";
	}
	@RequestMapping("/daikichi/today")
	public String today() {
		return "<h1>today you will find luc in all your endeavors!</h1> ";
	}
	
	 @RequestMapping("/daikichi/tomorrow")
	    public String tomorrow() {
	        return "tomorrow , an apportu,ity will arise,so be sure to be open to new ideas!" ;
	    }
	
}
