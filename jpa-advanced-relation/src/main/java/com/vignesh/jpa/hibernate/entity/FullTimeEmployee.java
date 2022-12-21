package com.vignesh.jpa.hibernate.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee{
	
	private BigDecimal salary;
	

	public FullTimeEmployee() {

	}
	
	public FullTimeEmployee(String name, BigDecimal salary) {
		super(name);
		this.salary = salary;
	}
	
}
