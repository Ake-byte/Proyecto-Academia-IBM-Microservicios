package com.ibm.ejercicio1.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ejercicio1.consumer.model.CreditCard;
import com.ibm.ejercicio1.consumer.model.Passion;
import com.ibm.ejercicio1.consumer.rest.CreditCardConsumer;

import feign.FeignException;

@RestController
@RequestMapping("/client")
public class ClientRestController {

	@Autowired
	private CreditCardConsumer consumer;

	@GetMapping("/availableCreditCards/{passion}/{salary}/{age}")
	public ResponseEntity<List<CreditCard>> getAvailableCreditCards(@PathVariable(value = "passion") String[] passion,
			@PathVariable(value = "salary") Double salary, @PathVariable(value = "age") Integer age) {

		List<CreditCard> availableCreditCards = consumer.listAvailableCreditCards(passion, salary, age);

		return new ResponseEntity<>(availableCreditCards, HttpStatus.OK);

	}
}
