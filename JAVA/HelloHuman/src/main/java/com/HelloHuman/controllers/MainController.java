package com.HelloHuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@RequestMapping("/")
		public String test() {
	
		return "hello";
	}
	 @RequestMapping("/")
	    public String index(@RequestParam(value="name") String NAME  ,@RequestParam(value="last_name", defaultValue="") String lastName, 
	    		 @RequestParam(value="times", defaultValue="1") int times) {
		 String response = "";
		    for (int i = 0; i < times; i++) {
		 response = "Hello, " + NAME + " " + lastName+"\n" ;
		    }
		 return response;
	    }
}
