package com.ibm.ejercicio2.producer2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ejercicio2.producer2.model.Bank;
import com.ibm.ejercicio2.producer2.service.IBankService;

@RestController
@RequestMapping("/bank")
public class BankRestController {

	@Autowired
	private IBankService bankService;

	@GetMapping(value = "/location/{gps}")
	public List<Bank> listBanks(@PathVariable(value = "gps") String[] gps) {
		
		List<Bank> allServicesLocation = bankService.getAllServicesLocation();
		
		List<Bank> banksAndBranches = new ArrayList<>();
		for(Bank bank : allServicesLocation) {
			if(bank.getServiceId().equals("100") || bank.getServiceId().equals("300")) {
					banksAndBranches.add(bank);
			}
		}
		
		double latGps = Double.parseDouble(gps[1]);
		double lonGps = Double.parseDouble(gps[0]);
		
		return bankService.findNearestBanksAndBranches(latGps, lonGps, banksAndBranches);
	}

	
}
