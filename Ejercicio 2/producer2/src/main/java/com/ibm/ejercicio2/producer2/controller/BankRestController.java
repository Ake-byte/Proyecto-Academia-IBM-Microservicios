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
				//if(bank.getState().equals(state))
					banksAndBranches.add(bank);
			}
		}
		
		double latGps = Double.parseDouble(gps[0]);
		double lonGps = Double.parseDouble(gps[1]);
		
		List<Bank> nearestBanksAndBranches = new ArrayList<>();
		for(Bank bank : banksAndBranches) {
			
			double latGps2 = Double.parseDouble(bank.getLatitude());
			double lonGps2 = Double.parseDouble(bank.getLongitude());
			
			double distance = distance(latGps, latGps2, lonGps, lonGps2);
			
			if(distance <= 5) {
				nearestBanksAndBranches.add(bank);
			}
		}

		return nearestBanksAndBranches;
	}

	public double distance(double lat1, double lat2, double lon1,
			double lon2) {

		double theta = lon1 - lon2;
		  double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		  dist = Math.acos(dist);
		  dist = rad2deg(dist);
		  dist = dist * 60 * 1.1515;
		  
		  dist = dist * 1.609344;
		  
		  return (dist);
	}
	
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::  This function converts decimal degrees to radians             :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private double deg2rad(double deg) {
	  return (deg * Math.PI / 180.0);
	}

	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::  This function converts radians to decimal degrees             :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private double rad2deg(double rad) {
	  return (rad * 180.0 / Math.PI);
	}
}
