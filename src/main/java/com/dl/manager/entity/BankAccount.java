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
import javax.validation.constraints.NotBlank;

import com.dl.manager.common.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author duskol May 12, 2019
 *
 */
@Entity
@Table(name="accounts")
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name="number", unique=true)
	private String accountNumber;
	
	@NotBlank
	@Column(name="bank")
	private String bankName;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "community_id", nullable = false)
	@JsonIgnore
	private Community community;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
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
		return "BankAccount [id=" + id + ", accountNumber=" + accountNumber + ", bankName=" + bankName + ", status="
				+ status + "]";
	}
}
