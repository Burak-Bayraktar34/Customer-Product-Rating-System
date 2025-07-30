package com.homework.Homework.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
public class Mark {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long markId;
	
	String markName;
	int totalvote;
	
	  @JsonBackReference
	  @ManyToOne(optional = true)
	  @JoinColumn(name = "customer_id")
	  Customer customer;
	
	@JsonBackReference
	@ManyToMany(mappedBy ="marks",cascade =CascadeType.ALL)
	List<Product> products;

	public Long getMarkId() {
		return markId;
	}

	public void setMarkId(Long markId) {
		this.markId = markId;
	}

	public String getMarkName() {
		return markName;
	}

	public void setMarkName(String markName) {
		this.markName = markName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	} 

	public int getTotalvote() {
		return totalvote;
	}

	public void setTotalvote(int totalvote) {
		this.totalvote = totalvote;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

	
}
