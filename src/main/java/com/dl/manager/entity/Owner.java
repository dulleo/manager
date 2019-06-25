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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * 
 * @author duskol May 12, 2019
 *
 */
@Entity
@Table(name="owners")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Owner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@NotBlank
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identification_number")
	private String identificationNumber;
	
	@Column(name="phone")
	private String phone;
	
	@Email
	@Column(name="email")
	private String email;
	
	@Column(name="street")
	private String street;
	
	@Column(name="street_number")
	private String streetNumber;
	
	@Column(name="city")
	private String city;
	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)//, fetch = FetchType.LAZY)
	//@JsonManagedReference
	@JsonIgnore
	private List<ApartmentOwner> apartmentOwners;// = new ArrayList<>();
	
	
	@ManyToOne(fetch=FetchType.LAZY, optional = false)
	@JoinColumn(name = "community_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Community community;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}

	public List<ApartmentOwner> getApartments() {
		return apartmentOwners;
	}

	public void setApartments(List<ApartmentOwner> apartments) {
		this.apartmentOwners = apartments;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", identificationNumber=" + identificationNumber + ", phone=" + phone + ", email=" + email
				+ ", street=" + street + ", streetNumber=" + streetNumber + ", city=" + city + ", apartments="
				+ apartmentOwners + ", community=" + community + "]";
	}

}
