package com.ibm.ejercicio1.producer.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="passions")
public class Passion implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="passion_id")
	private Long passionId;
	
	@Column(name="passion_name")
	private String passionName;
	
	
	@OneToMany(mappedBy="passions" ,cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JsonIgnore
	private List<CreditCard> creditCard;
	
	public Passion() {
		creditCard = new ArrayList<CreditCard>();
	}
	
	public void addCreditCards(CreditCard card) {
		creditCard.add(card);
	}



	private static final long serialVersionUID = 1L;

}
