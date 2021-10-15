package com.ibm.ejercicio2.producer2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bank {
	//id
	private String id;
    //serviceId
	private String serviceId;
    //address
	private String dos;
    private String tres;
    
    //Postal Code
    private String postalCode;
    
    private String cinco;
    private String seis;
    private String siete;
    private String ocho;
    private String nueve;
    private String diez;
    private String once;
    private String doce;
    private String trece;
    private String catorce;
    
    /*----GPS-----*/
    //latitude
    private String latitude;
    //longitude
    private String longitude;
    
    private String State;
    
    private String dieciocho;
    
    //serviceName
    private String serviceName;
}
