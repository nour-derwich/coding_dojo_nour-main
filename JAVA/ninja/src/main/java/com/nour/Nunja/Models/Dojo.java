package com.nour.Nunja.Models;

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
@Table(name="dojo")
public class Dojo {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@NotNull()
@Size(min = 5, max = 200,message="name should not be empty")
private String name;
@Column(updatable=false)
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date createdAt;
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date updatedAt;
@OneToMany(mappedBy="dojo",fetch=FetchType.LAZY)
private List <Ninja>ninjas;

public List<Ninja> getNinjas() {
	return ninjas;
}
public void setNinjas(List<Ninja> ninjas) {
	this.ninjas = ninjas;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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

public  Dojo()
{
	
}
public Dojo(Long id, String name) {

	this.id = id;
	this.name = name;
	
}


	
}
