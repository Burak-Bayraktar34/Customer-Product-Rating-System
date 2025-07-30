package com.homework.Homework.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long customerId;
	
	String customerName;
	
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	List<Mark> marks;

	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Mark> getAddingVote() {
		return marks;
	}

	public void setAddingVote(List<Mark> addingVote) {
		marks = addingVote;
	}

	
	
	
	
}
