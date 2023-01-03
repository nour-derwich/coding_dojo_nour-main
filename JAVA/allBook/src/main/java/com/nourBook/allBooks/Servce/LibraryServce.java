package com.nourBook.allBooks.Servce;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nourBook.allBooks.Models.Library;
import com.nourBook.allBooks.Repository.LibraryRepository;

@Service
public class LibraryServce {
	  @Autowired
	    private LibraryRepository libraryrepo;
	    // returns all the books
	    public List<Library> allLibrarys() {
	        return libraryrepo.findAll();
	    }
	    // creates a book
	    public Library createLibrary(Library b) {
	        return libraryrepo.save(b);
	    }
	    // retrieves a Library
	    public Library findLibrary(Long id) {
	        Optional<Library> optionalLibrary = libraryrepo.findById(id);
	        if(optionalLibrary.isPresent()) {
	            return optionalLibrary.get() ;
	        } else {
	            return null;
	        }
	       
	    }
		public Library updateLibrary(Library b) {
			// TODO Auto-generated method stub
			return libraryrepo.save(b);			
		}
		public void deleteLibrary(Long id)
		{
			libraryrepo.deleteById(id);
		}
}
