package com.nour.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	public class Counter {
	    private int count;
	    
	    public Counter() {
	      this.count = 0;
	    }
	    
	    public void increment() {
	      count++;
	    }
	    
	    public void decrement() {
	      count--;
	    }
	    public int getCount() {
	        return count;
	      }
	    public void incrementByTwo() {
	        count += 2;
	      }
	    public void reset() {
	        count = 0;
	      }
	}
	 @RequestMapping("/")
	  public String index(HttpSession session) {
	    Counter counter = (Counter) session.getAttribute("counter");
	    if (counter == null) {
	      counter = new Counter();
	      session.setAttribute("counter", counter);
	    }
	    counter.increment();
	    return "index.jsp";
	  }
	 @RequestMapping("/counter")
	  public String counter(HttpSession session, Model model) {
	    Counter counter = (Counter) session.getAttribute("counter");
	    model.addAttribute("counter", counter);
	    return "counter.jsp";
	  }
	 @RequestMapping("/incrementByTwo")
	  public String incrementByTwo(HttpSession session) {
	    Counter counter = (Counter) session.getAttribute("counter");
	    counter.incrementByTwo();
	    return "index.jsp";
	  }
	 @RequestMapping("/reset")
	  public String reset(HttpSession session) {
	    Counter counter = (Counter) session.getAttribute("counter");
	    counter.reset();
	    return "reset.jsp";
	  }
}
