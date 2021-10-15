package com.ibm.ejercicio2.consumer2.rest;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.ejercicio2.consumer2.model.Bank;


@FeignClient(name = "SEARCH-BANK-SERVICE")
public interface IBankRest {
	
	@GetMapping(value = "/bank/location/{state}")
	public List<Bank> listBanks(
			@PathVariable(value = "state") String state);
}
