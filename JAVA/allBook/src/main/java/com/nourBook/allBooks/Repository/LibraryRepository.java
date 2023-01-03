package com.nourBook.allBooks.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nourBook.allBooks.Models.Library;

@Repository
public interface LibraryRepository extends CrudRepository<Library,Long>  {
List <Library> findAll();
}
