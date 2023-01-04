package com.nour.BookClub.Servec;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nour.BookClub.Models.Book;
import com.nour.BookClub.Repository.BookRepository;

@Service
public class BookServec {
	// CRUD
	   // adding the book repository as a dependency
@Autowired
private BookRepository BookRepository;
 
 
 // READ ALL
 public List<Book> allBooks() {
     return BookRepository.findAll();
 }
 // CREATE ONE
 public Book createBook(Book b) {
     return BookRepository.save(b);
 }
 // READ ONE
 public Book findBook(Long id) {
     Optional<Book> optionalBook = BookRepository.findById(id);
     
     if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
//     optionalBook.isPresent() ? return optionalBook.get() : return null;
 }
 
 // UPDATE BOOK
 public Book updateBook(Book b) {
 	return BookRepository.save(b);
 }
 
 //TODO DELETE method
 
 public void deleteBook(Long id) {
	 BookRepository.deleteById(id);
 }
}
