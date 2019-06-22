package com.dl.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.dl.manager.common.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author duskol May 12, 2019
 *
 */
@Entity
@Table(name="owners")
public class AppartmentOwner {
	
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
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status;
	
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}

	@Override
	public String toString() {
		return "AppartmentOwner [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", identificationNumber=" + identificationNumber + ", phone=" + phone + ", email=" + email
				+ ", street=" + street + ", streetNumber=" + streetNumber + ", city=" + city + ", status=" + status
				+ ", community=" + community + "]";
	}
	
}
