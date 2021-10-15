package com.ibm.ejercicio1.producer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ibm.ejercicio1.producer.model.Passion;

public interface IPassionDao extends CrudRepository<Passion, Long>{
	
	@Query("select p from Passion p where p.passionName like %?1%")
	public Passion findPassionByName(String passionName);
}
