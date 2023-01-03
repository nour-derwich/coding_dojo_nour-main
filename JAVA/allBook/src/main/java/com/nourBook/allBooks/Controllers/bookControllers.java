package com.nourBook.allBooks.Controllers;

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

import com.nourBook.allBooks.Models.Book;
import com.nourBook.allBooks.Models.Library;
import com.nourBook.allBooks.Servce.LibraryServce;
import com.nourBook.allBooks.Servce.bookServce;





@Controller
public class bookControllers {
	@Autowired
	private bookServce bookServce;
	@Autowired
	private LibraryServce LibrarySe;
	@GetMapping("/")
	public String allBooks(Model model)
	{
	List <Book> allBooks=bookServce.allBooks();
	
		model.addAttribute("allmylove",allBooks);
		return "index.jsp";
	}
	@GetMapping("/create")
	public String create(@ModelAttribute("book")Book book , Model model)
	{

	List <Library> allLibs=LibrarySe.allLibrarys();
	model.addAttribute("allLibs",allLibs);
		return "form.jsp";
	}
	@PostMapping("/createbooks")
	public String create(@Valid @ModelAttribute("book")Book book 
			, BindingResult result,
			Model model)
	{
		if (result.hasErrors()) {
			List <Library> Libs=LibrarySe.allLibrarys();
			model.addAttribute("allLibs",Libs);
            return "form.jsp";
        } else {
        	bookServce.createBook(book);
            return "redirect:/";
        }
	}
	
//	@PostMapping("/createbooks")
//	public String create(
//			@RequestParam("title") String title,
//			@RequestParam("author") String author,
//			@RequestParam("pages") Integer pages,
//			Model model)
//	{
//		Book book = new Book(title, author, pages);
//	Book newbook=bookServce.createBook(book);
//		model.addAttribute(newbook);
//	return "/redirect:/";
//	}
	
	
	//update
	@GetMapping("/edit/{id}")
	public String updatePage(@PathVariable("id") Long bookId, Model model)
	{
		Book book=bookServce.findBook(bookId);
		model.addAttribute("book",book);
		return "edit.jsp";
	}
	
	@RequestMapping(value="/books/{id}",method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("book")Book book, BindingResult result)
	{	if(result.hasErrors())
	{
		return "/edit.jsp";
	}
	else {
		bookServce.updateBook(book);
		return "redirect:/";
	}
}
	//delete
	 @DeleteMapping("/books/{id}")
	    public String destroy(@PathVariable("id") Long id) {
		 bookServce.deleteBook(id);
	        return "redirect:/";
	    }}
