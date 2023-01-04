package com.nour.BookClub.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.tomcat.jni.Library;
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

import com.nour.BookClub.Models.Book;
import com.nour.BookClub.Models.User;
import com.nour.BookClub.Servec.BookServec;
import com.nour.BookClub.Servec.UserServce;

@Controller
public class BookController {
	@Autowired
	private BookServec bookService;
	
	
	@Autowired
	private UserServce userServ;
	
	// Show all Books
	
//	@GetMapping("/home")
//	public String allBooks(Model model) {
//		List <Book> allBooks  = bookService.allBooks();
//		model.addAttribute("allMybooks", allBooks);
//		return "home.jsp";
//	}
//	
	
	
	// CREATE - Show form
		@GetMapping("/create")
		public String create(@ModelAttribute("book") Book book, Model model) {
		
			return "form.jsp";
		}
	
	
	
	
	

		// CREATE - redirect - process the form
		@PostMapping("/createBook")
		public String create(@Valid @ModelAttribute("book") Book book,
				BindingResult result,
				Model model,
				HttpSession session) {
			
			 if (result.hasErrors()) {
				
		            return "form.jsp";
		        } else {
		        	Long userId = (Long) session.getAttribute("user_id");
		        	// Find user by ID
		        	User currentUser = userServ.findUserById(userId);
		        	
		        	book.setUser(currentUser);
		        	// Create a book in the DB
		            bookService.createBook(book);
		            return "redirect:/home";
		        }
		}
		// TO-DO RedirectAttributes "You have successfully create a book
		//show book
		@GetMapping("/show/{id}")
		public String showPage(@PathVariable("id") Long bookId, Model model) {
			Book book= bookService.findBook(bookId);
			model.addAttribute("book", book);
			return "show.jsp";
		}
		//edit 
		@GetMapping("/edit/{id}")
		public String updatePage(@PathVariable("id") Long bookId, Model model) {
			Book book= bookService.findBook(bookId);
			model.addAttribute("book", book);
			return "edit.jsp";
		}
		// Rendering the edit page == GET ==
		
		
		// Processing the edit form == PUT==
		 @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
		    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		        if (result.hasErrors()) {
		            return "edit.jsp";
		        } else {
		        	// Fetch the book object from DB
		        	Book orginalBook = bookService.findBook(book.getId());
		        	book.setUser(orginalBook.getUser());
		        	

		            bookService.updateBook(book);
		            return "redirect:/home";
		        }
		    }
		 
		 //DELETE
		    @DeleteMapping("/books/{id}")
		    public String destroy(@PathVariable("id") Long id) {
		        bookService.deleteBook(id);
		        return "redirect:/home";
		    }
}
