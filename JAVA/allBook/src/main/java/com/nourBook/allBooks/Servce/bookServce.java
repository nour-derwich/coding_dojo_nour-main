package com.nourBook.allBooks.Servce;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nourBook.allBooks.Models.Book;
import com.nourBook.allBooks.Repository.bookRepository;

@Service
public class bookServce {
//CRUD
	
	    @Autowired
	    private bookRepository bookrepo;
	    // returns all the books
	    public List<Book> allBooks() {
	        return bookrepo.findAll();
	    }
	    // creates a book
	    public Book createBook(Book b) {
	        return bookrepo.save(b);
	    }
	    // retrieves a book
	    public Book findBook(Long id) {
	        Optional<Book> optionalBook = bookrepo.findById(id);
	        if(optionalBook.isPresent()) {
	            return optionalBook.get() ;
	        } else {
	            return null;
	        }
	       
	    }
		public Book updateBook(Book b) {
			// TODO Auto-generated method stub
			return bookrepo.save(b);			
		}
		public void deleteBook(Long id)
		{
			bookrepo.deleteById(id);
		}
}
