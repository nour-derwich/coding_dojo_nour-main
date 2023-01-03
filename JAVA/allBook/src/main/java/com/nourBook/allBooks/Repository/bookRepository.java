package com.nourBook.allBooks.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nourBook.allBooks.Models.Book;

@Repository
public interface bookRepository extends CrudRepository<Book,Long> {
List<Book> findAll();
}
