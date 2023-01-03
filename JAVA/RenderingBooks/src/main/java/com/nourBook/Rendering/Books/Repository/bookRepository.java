package com.nourBook.Rendering.Books.Repository;


import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nourBook.Rendering.Books.Models.BookModel;

@Repository
public interface  bookRepository extends CrudRepository<BookModel, Long> {
	List <BookModel> findAll();
  List<BookModel> findByTitle(String title);
  Optional<BookModel> findById(Long id);
BookModel save(Book book);
}
