package com.ibm.ejercicio1.producer.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="credit_cards")
public class CreditCard implements Serializable{	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long creditCardId;
	
	@Column(name="credit_card_name")
	private String creditCardName;
	
	@Column(name="min_salary")
	private Double minSalary;
	
	@Column(name="max_salary")
	private Double maxSalary;
	
	@Column(name="min_age")
	private Integer minAge;
	
	@Column(name="max_age")
	private Integer maxAge;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}  )
	@JoinColumn(name = "passion_id")
	private Passion passions;
	
	private static final long serialVersionUID = 1L;
}
