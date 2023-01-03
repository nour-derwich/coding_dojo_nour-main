package com.nourBook.allBooks.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="books")
public class Book {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 @NotNull()
	    @Size(min = 5, max = 200,message="Title should not be empty")
	private String title;
	 @NotNull
	    @Size(min = 5, max = 200,message="ather should not be empty")
	private String author;
	 @NotNull(message="page should not be empty")
	 @Min(100)
	private Integer pages;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="library_id")
	
	private Library library;
	
	 public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}
	@Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    public Long getId() {
		return id;
	}
	    
	    public Book()
	    {
	    	
	    };
	    
	    public Book(Long id, String title, String author, Integer pages) {
			
			this.id = id;
			this.title = title;
			this.author = author;
			this.pages = pages;
			
		}
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	//the one getter and setter
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
		@DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;

}
