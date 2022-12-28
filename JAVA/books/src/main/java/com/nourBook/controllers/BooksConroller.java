package com.nourBook.controllers;

import java.awt.print.Book;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nourBook.services.BookServer;

public class BooksConroller {
	   private final BookServer server;
	    public BooksConroller(BookServer server){
	        this.server = server;
	    }
	    @RequestMapping("/api/books")
	    public List<Book> index() {
	        return server.allBooks();
	    }
	    
	    @RequestMapping(value="/api/books", method=RequestMethod.POST)
	    public Book create(@RequestParam(value="title") String title,
	    		@RequestParam(value="description") String desc,
	    		@RequestParam(value="language") String lang,
	    		@RequestParam(value="pages") Integer numOfPages) {
	        Book book = new Book(title, desc, lang, numOfPages);
	        return server.createBook(book);
	    }
	    
	    @RequestMapping("/api/books/{id}")
	    public Book show(@PathVariable("id") Long id) {
	        Book book = server.findBook(id);
	        return book;
	    }
	    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
	    public Book update(
	    		@PathVariable("id") Long id, 
	    		@RequestParam(value="title") String title, 
	    		@RequestParam(value="description") String description, 
	    		@RequestParam(value="language") String lang,
	    		@RequestParam(value="pages") Integer numOfPages) {
	    	
	    	
	    	Book book = new Book(title, description, lang, numOfPages);
	    	book.setId(id);
	    	
	        book = server.updateBook(book);
	        
	        return book;
	    }
	    
	    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
	    public void destroy(@PathVariable("id") Long id) {
	        server.deleteBook(id);
	    }


}
