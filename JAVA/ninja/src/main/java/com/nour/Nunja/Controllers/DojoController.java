package com.nour.Nunja.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nour.Nunja.Models.Dojo;

import com.nour.Nunja.Servce.DojoServce;


@Controller
public class DojoController {
	@Autowired
	private DojoServce DojoSe;
	
	@GetMapping("/")
	public String allDojos(Model model)
	{
	List <Dojo> allDojos=DojoSe.allDojo();

		model.addAttribute("allDojos",allDojos);
		return "index.jsp";
	}
	
	
	@GetMapping("/createdojo/new")
	public String createdojo(@ModelAttribute("dojo")Dojo dojo, Model model)
	{
		List<Dojo> alldojo=DojoSe.allDojo();
		model.addAttribute("alldojo",alldojo);
		return "dojoForm.jsp";
	}
	@PostMapping("createDojo")
	public String processForm(@Valid @ModelAttribute("dojo") Dojo dojo,BindingResult result)
	{
		if(result.hasErrors())
		{
			return  "dojoForm.jsp";
		}else
		{
			DojoSe.createDojo(dojo);
			return "redirect:/";
		}
		
		
	}
	@GetMapping("/dojo/{id}")
	public String getDojo(@PathVariable("id") Long id, Model model)
	{
		Dojo dojo=DojoSe.findDojo(id);
		model.addAttribute("dojo",dojo);
		return "display.jsp";
	}
	
	
	
	
}
