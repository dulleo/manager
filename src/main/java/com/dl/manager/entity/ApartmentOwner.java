package com.dl.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.MapsId;
import javax.persistence.Table;

import com.dl.manager.common.Status;

/**
 * 
 * @author duskol Jun 23, 2019
 *
 */
@Entity
@Table(name="apartment_owner")
public class ApartmentOwner {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
    private Owner owner;
	
	@ManyToOne
	@JoinColumn(name = "apartment_id")
    private Apartment apartment;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ApartmentOwner [id=" + id + ", owner=" + owner + ", apartment=" + apartment + ", status=" + status
				+ "]";
	}

}
