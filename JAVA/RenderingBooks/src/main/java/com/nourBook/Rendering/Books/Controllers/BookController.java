package com.nourBook.Rendering.Books.Controllers;

import java.awt.print.Book;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nourBook.Rendering.Books.Models.BookModel;
import com.nourBook.Rendering.Books.Servces.bookServce;

@RestController
public class BookController {

	//Get books first step
	private final bookServce service;
	

	public BookController(bookServce service) {
		this.service = service;
	}
	//creat books
	 @RequestMapping(value="/api/books", method=RequestMethod.POST)
	    public BookModel create(
	    		@RequestParam(value="title") String title, 
	    		@RequestParam(value="description") String desc, 
	    		@RequestParam(value="language") String lang, 
	    		@RequestParam(value="pages") Integer numOfPages) {
	    	
		 BookModel book = new BookModel(title, desc, lang, numOfPages);
	        return service.createBook(book);
	    }
	    
	    @RequestMapping("/api/books/{id}")
	    public BookModel show(@PathVariable("id") Long id) {
	    	BookModel book = service.findBook(id);
	        return book;
	    }
	//get books
	@RequestMapping("/api/books")
    public List<BookModel> index() {
		List <BookModel> books = service.allBooks();
		System.out.println(books);
        return books;
    }
    
	// Add necessary dependencies and settings for using JSP here

	  @GetMapping("/books/{id}")
	  public String showBook(@PathVariable("id") Long id, Model model) {
	    // Retrieve book with the given ID from the database
		  BookModel book = service.findBook(id);
	    // Add the book to the model
	    model.addAttribute("book", book);
	    // Render the show.jsp view with the book information
	    return "show.jsp";
	  }
	
	
	
}
