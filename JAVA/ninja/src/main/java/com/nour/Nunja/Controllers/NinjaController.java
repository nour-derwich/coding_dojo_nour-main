package com.nour.Nunja.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nour.Nunja.Models.Dojo;
import com.nour.Nunja.Models.Ninja;
import com.nour.Nunja.Servce.DojoServce;
import com.nour.Nunja.Servce.NinjaServce;



@Controller
public class NinjaController {
@Autowired
private NinjaServce NinjaServce;
@Autowired
private DojoServce DojoServce;

//@GetMapping("/")
//public String allNinjas(Model model)
//{
//List <Ninja> allNinjas=NinjaServce.allNinjas();
//
//	model.addAttribute("ninjaGO",allNinjas);
//	return "index.jsp";
//}
@GetMapping("/create")
public String create(@ModelAttribute("ninja")Ninja ninja , Model model)
{

List <Dojo> alldojs=DojoServce.allDojo();
model.addAttribute("allDojs",alldojs);
	return "form.jsp";
}

@PostMapping("/createninjas")
public String create(@Valid @ModelAttribute("ninja")Ninja ninja 
		, BindingResult result,
		Model model)
{
	if (result.hasErrors()) {
		List <Dojo> Dojo=DojoServce.allDojo();
		model.addAttribute("allDojs",Dojo);
        return "form.jsp";
    } else {
    	NinjaServce.createNinja(ninja);
        return "redirect:/";
    }
}

//update
@GetMapping("/edit/{id}")
public String updatePage(@PathVariable("id") Long ninjaId, Model model)
{
	Ninja ninja=NinjaServce.findNinja(ninjaId);
	model.addAttribute("ninja",ninja);
	return "edit.jsp";
}

@RequestMapping(value="/ninja/{id}",method=RequestMethod.PUT)
public String update(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result)
{	if(result.hasErrors())
{
	return "/edit.jsp";
}
else {
	NinjaServce.updateNinja(ninja);
	return "redirect:/";
}
}
//delete
 @DeleteMapping("/ninjas/{id}")
    public String destroy(@PathVariable("id") Long id) {
	 NinjaServce.deleteNinja(id);
        return "redirect:/";
    }}

