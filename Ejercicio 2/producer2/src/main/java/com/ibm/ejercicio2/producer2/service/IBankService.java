package com.ibm.ejercicio2.producer2.service;

import java.util.List;

import com.ibm.ejercicio2.producer2.model.Bank;

public interface IBankService {
	public List<Bank> getAllServicesLocation();
	public List<Bank> findNearestBanksAndBranches(double latGps, double lonGps, List<Bank> banksAndBranches);
}
