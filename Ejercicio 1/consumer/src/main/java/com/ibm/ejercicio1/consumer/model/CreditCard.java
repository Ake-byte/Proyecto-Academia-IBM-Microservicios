package com.ibm.ejercicio1.consumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {
	
	private String creditCardName;

	private Passion passions;

}
