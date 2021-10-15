package com.ibm.ejercicio1.consumer.rest;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.ejercicio1.consumer.model.CreditCard;

@FeignClient(name = "CREDIT-CARD-SERVICE")

public interface CreditCardConsumer {

	@GetMapping("/creditCard/availableCreditCards/{passion}/{salary}/{age}")
	public List<CreditCard> listAvailableCreditCards(
			@PathVariable(value = "passion") String[] passion,
			@PathVariable(value = "salary") Double salary, 
			@PathVariable(value = "age") Integer age);
}
