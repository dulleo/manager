package com.dl.manager.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * 
 * @author duskol May 12, 2019
 *
 */
@Entity
@Table(name="apartments")
public class Apartment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="number", unique=true)
	@NotNull(message= "Appartment number may not be empty")
	private Integer apartmentNumber;
	
	@ManyToOne(fetch=FetchType.LAZY, optional = false)
	@JoinColumn(name = "doorway_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Doorway doorway;
	
	@OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL, orphanRemoval = true) 
	@JsonIgnore
	private List<ApartmentOwner> apartmentOwners;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(Integer apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public List<ApartmentOwner> getApartmentOwners() {
		return apartmentOwners;
	}

	public void setApartmentOwners(List<ApartmentOwner> apartmentOwners) {
		this.apartmentOwners = apartmentOwners;
	}
	
	public Doorway getDoorway() {
		return doorway;
	}

	public void setDoorway(Doorway doorway) {
		this.doorway = doorway;
	}

	@Override
	public String toString() {
		return "Apartment [id=" + id + ", apartmentNumber=" + apartmentNumber + ", doorway=" + doorway
				+ ", apartmentOwners=" + apartmentOwners + "]";
	}
}
