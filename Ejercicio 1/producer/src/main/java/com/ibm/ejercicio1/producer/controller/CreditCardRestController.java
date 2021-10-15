package com.ibm.ejercicio1.producer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ejercicio1.producer.model.CreditCard;
import com.ibm.ejercicio1.producer.model.Passion;
import com.ibm.ejercicio1.producer.service.IPassionService;

@RestController
@RequestMapping("/creditCard")
public class CreditCardRestController {

	@Autowired
	private IPassionService passionService;

	@GetMapping("/availableCreditCards/{passion}/{salary}/{age}")
	public List<CreditCard> listAvailableCreditCards(@PathVariable(value = "passion") String[] passionName,
			@PathVariable(value = "salary") Double salary, @PathVariable(value = "age") Integer age) {

		List<Passion> passions = new ArrayList<>();
		
		for(String names : passionName) {
			Passion passion = passionService.findPassionByName(names);
			passions.add(passion);
		}
		
		List<CreditCard> creditsCard = null;
		List<CreditCard> availableCreditCard = new ArrayList<>();
		for(Passion p : passions) {
			creditsCard = p.getCreditCard();
			for (CreditCard cc : creditsCard) {
				if (age >= cc.getMinAge() && age <= cc.getMaxAge()) {
					if (cc.getMaxSalary() != null) {
						if (salary >= cc.getMinSalary() && salary <= cc.getMaxSalary()) {
							availableCreditCard.add(cc);
						}
					} else {
						if (salary >= cc.getMinSalary()) {
							availableCreditCard.add(cc);
						}
					}
				}
			}
		}
		
		return availableCreditCard;
	}
}
