package com.nour.Nunja.Models;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ninjas")
public class Ninja {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 @NotNull()
	    @Size(min = 5, max = 200,message="Title should not be empty")
	private String first_name;
	 @NotNull
	    @Size(min = 5, max = 200,message="ather should not be empty")
	private String last_name;
	 @NotNull(message="page should not be empty")

	private Integer age;
	 @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	   
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
//
	 @ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="dojo_id")
	 private Dojo dojo;
	 //
	 public Ninja()
	 {
		 
	 }
	 
	 
	 
	 public Dojo getDojo() {
		return dojo;
	}



	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}



	public Ninja(Long id,
			String first_name,
			 String last_name,
			 Integer age) {

		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
	}

//
	 

	//
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

}

