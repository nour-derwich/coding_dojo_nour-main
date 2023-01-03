package com.nourBook.allBooks.Controllers;

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

import com.nourBook.allBooks.Models.Library;
import com.nourBook.allBooks.Servce.LibraryServce;

@Controller
public class LibraryController {
	@Autowired
	private LibraryServce librarySvc;
	
@GetMapping("/libraries")
public String allLibraries( Model model )
{
	List<Library> listOflibrary=librarySvc.allLibrarys();
	model.addAttribute("allLibrary", listOflibrary);
	
	return"libraries.jsp";
}
@GetMapping("/createLibrary/new")
public String createLib(@ModelAttribute("library") Library library, Model model)
{
	List<Library> allLibs= librarySvc.allLibrarys();
	model.addAttribute("allLibs", allLibs);
	return "libForm.jsp";
}
@PostMapping("createLibrary")
public String processForm(@Valid @ModelAttribute("library")Library library, BindingResult result)
{
	if(result.hasErrors())
	{
		return  "libForm.jsp";
	}else
	{
		librarySvc.createLibrary(library);
		return "redirect:/";
	}
}
@GetMapping("/library/{id}")
public String getLibrary(@PathVariable("id") Long id, Model model)
{
	Library library=librarySvc.findLibrary(id);
	model.addAttribute("library",library);
	return "libraries.jsp";
}
}
