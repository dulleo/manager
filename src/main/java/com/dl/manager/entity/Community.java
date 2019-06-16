package com.dl.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author duskol May 12, 2019
 *
 */
@Entity
@Table(name="communities")
public class Community {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name="name", unique=true)
	private String name;
	
	@Column(name="identification_number", unique=true)
	@NotNull(message= "Identification number may not be empty")
	private Integer identificationNumber;

	@Column(name="pib", unique=true)
	@NotNull(message= "Pib may not be empty")
	private Integer pib;

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
	
	public Integer getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(Integer identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public Integer getPib() {
		return pib;
	}

	public void setPib(Integer pib) {
		this.pib = pib;
	}
}
