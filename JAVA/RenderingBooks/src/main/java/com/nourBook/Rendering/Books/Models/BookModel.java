package com.nourBook.Rendering.Books.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class BookModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String title;
 
    private String description;
   
    private String language;
   
    private Integer numberOfPages;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
    
    public BookModel() {
		
	}


	public BookModel(Long id, String title, String description, String language, Integer numberOfPages, Date createdAt,
			Date updatedAt) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.language = language;
		this.numberOfPages = numberOfPages;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	 //-----//
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Integer getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
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
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    
    
    

}
