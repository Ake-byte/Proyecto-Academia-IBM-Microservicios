package com.ibm.ejercicio2.consumer2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ejercicio2.consumer2.model.Bank;
import com.ibm.ejercicio2.consumer2.rest.IBankRest;

@RestController
@RequestMapping("/client")
public class BankRestController {
	@Autowired
	private IBankRest bankRest;

	@GetMapping(value = "/searchBank/{state}")
	public List<Bank> listBanks(@PathVariable(value = "state") String state){
		return bankRest.listBanks(state);
	}

}
