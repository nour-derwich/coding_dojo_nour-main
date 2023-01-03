package com.nourBook.Rendering.Books.Servces;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nourBook.Rendering.Books.Models.BookModel;
import com.nourBook.Rendering.Books.Repository.bookRepository;

@Service
public class bookServce {
private final bookRepository repo;
	
	public bookServce(bookRepository repo) {
		this.repo = repo;
	}
	
	public List<BookModel> allBooks() {
		return repo.findAll();
	}
	
	public BookModel createBook(Book book) {
		return repo.save(book);
	}
	
	public BookModel findBook(Long id) {
		
		Optional<BookModel> book = repo.findById(id);
		if (book.isPresent()) {
			return book.get();
		}
		else {
			return null;
		}
	}
	
	public BookModel updateBook(BookModel book) {
		
		return repo.save(book);
	}
	
	public void deleteBook(Long id) {
		repo.deleteById(id);
	}
}
