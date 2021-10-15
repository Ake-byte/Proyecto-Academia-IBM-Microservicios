package com.ibm.ejercicio2.producer2.service;

import java.util.List;

import com.ibm.ejercicio2.producer2.model.Bank;

public interface IBankService {
	public List<Bank> getAllServicesLocation();
	public List<Bank> findPostalCodeByState(String postalCode, List<Bank> banks);
}
