package com.nour.test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EntryPointController {
@RequestMapping("/")
public String home() {
	return "home.jsp";
	}
}
