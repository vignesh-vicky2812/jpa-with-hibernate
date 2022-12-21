package com.vignesh.jpa.hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vignesh.jpa.hibernate.entity.Employee;
import com.vignesh.jpa.hibernate.entity.PartTimeEmployee;

@Repository
@Transactional

public class EmployeeRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager entityManager;

	public void insert(Employee employee) {
		entityManager.persist(employee);
	}
	
	public List<Employee> retrieveAllEmployees() {
		return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
	}
}
