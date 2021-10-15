package com.ibm.ejercicio1.producer.service;


import com.ibm.ejercicio1.producer.model.Passion;

public interface IPassionService {
	public Passion findPassion(Long id);
	public Passion findPassionByName(String passionName);
}
