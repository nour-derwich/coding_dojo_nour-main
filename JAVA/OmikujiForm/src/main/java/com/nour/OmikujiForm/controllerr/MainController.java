package com.nour.OmikujiForm.controllerr;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class MainController {
	
	@RequestMapping("/omikuji")
	public String showForm() {
	        return "omikuji.jsp";
	    }
	  @RequestMapping("/omikuji/show")
	  public String showResult() {
		   
		    return "show.jsp";
		}
	  @RequestMapping("/omikuji/process")
	    public String processForm(@RequestParam("number") int number,
	    		                  @RequestParam("city") String city,
	    		                  @RequestParam("name") String name,
	    		                  @RequestParam("hobby") String hobby,
	    		                  @RequestParam("type") String type,
	    		                  @RequestParam("something") String something,
	    		
	                             
	                              HttpSession session) {
	        session.setAttribute("name", name);
	        session.setAttribute("number", number);
	        session.setAttribute("city", city);
	        session.setAttribute("hobby", hobby);
	        session.setAttribute("type", type);
	        session.setAttribute("something", something);
	        return "redirect:/omikuji/show";
	    }
}
