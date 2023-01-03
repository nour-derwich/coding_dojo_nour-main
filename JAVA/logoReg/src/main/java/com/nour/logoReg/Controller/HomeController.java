package com.nour.logoReg.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
@RequestMapping("/home")
public String home(HttpSession s) {
	Long userId = (Long) s.getAttribute("user_id");
	
	if(userId == null) {
		return "redirect:/";
	}
	String userName = (String) s.getAttribute("userName");
	return "home.jsp";
}
}
