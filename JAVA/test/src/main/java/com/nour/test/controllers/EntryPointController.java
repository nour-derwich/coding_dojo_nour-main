package com.nour.test.controllers;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EntryPointController {
@RequestMapping("/")
public String home() {
	return "home.jsp";
	}
@GetMapping("/date")
public String date(Model model) {
  Date date = new Date();
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, the d of MMMM, yyyy");
  String formattedDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(formatter);
  model.addAttribute("date", formattedDate);
  return "date.jsp";
}
@GetMapping("/time")
public String time(Model model) {
  LocalTime time = LocalTime.now();
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
  String formattedTime = time.format(formatter);
  model.addAttribute("time", formattedTime);
  return "time.jsp";
}

}
