package com.ibm.ejercicio2.producer2.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Servicios {
	
	private Long id;
	
	private List<Bank> bank;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Bank> getBank() {
		return bank;
	}

	public void setBank(List<Bank> bank) {
		this.bank = bank;
	}
	
	
}