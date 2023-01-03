package com.nourBook.allBooks.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="library")
public class Library {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	@NotNull()
    @Size(min = 5, max = 200,message="name should not be empty")
private String name;
	@NotNull()
    @Size(min = 5, max = 200,message="location should not be empty")
private String location;

	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@OneToMany(mappedBy="library",fetch=FetchType.LAZY)
	
	private List<Book>books;

@Column(updatable=false)
   @DateTimeFormat(pattern="yyyy-MM-dd")
   private Date createdAt;
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date updatedAt;

   public Long getId() {
	return id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public Date getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}
public void setId(Long id) {
	this.id = id;
}
//Constructor
public Library()
{
	
}
public Library(String name, String location) {
	
	this.name = name;
	this.location = location;
}

}
