package com.ibm.ejercicio1.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ejercicio1.consumer.model.CreditCard;
import com.ibm.ejercicio1.consumer.model.Passion;
import com.ibm.ejercicio1.consumer.rest.CreditCardConsumer;

@RestController
@RequestMapping("/client")
public class ClientRestController {
	
	@Autowired
	private CreditCardConsumer consumer;
	
	@GetMapping("/availableCreditCards/{passion}/{salary}/{age}")
	public List<CreditCard> getAvailableCreditCards(
			@PathVariable(value = "passion") String[] passion,
			@PathVariable(value = "salary") Double salary,
			@PathVariable(value = "age") Integer age) {
		return consumer.listAvailableCreditCards(passion, salary, age);
	}
}
