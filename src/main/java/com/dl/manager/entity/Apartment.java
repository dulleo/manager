package com.dl.manager.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * 
 * @author duskol May 12, 2019
 *
 */
@Entity
@Table(name="apartments")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Apartment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="number", unique=true)
	@NotNull(message= "Appartment number may not be empty")
	private Integer number;
	
	//@JsonManagedReference
	@OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL, orphanRemoval = true) //, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ApartmentOwner> apartmentOwners;// = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public List<ApartmentOwner> getOwners() {
		return apartmentOwners;
	}

	public void setOwners(List<ApartmentOwner> owners) {
		this.apartmentOwners = owners;
	}

	@Override
	public String toString() {
		return "Apartment [id=" + id + ", number=" + number + ", owners=" + apartmentOwners + "]";
	}
	
}
