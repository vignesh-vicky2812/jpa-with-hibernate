package com.vignesh.jpa.hibernate.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.vignesh.jpa.hibernate.JpaAdvancedApplication;
import com.vignesh.jpa.hibernate.entity.Student;

@SpringBootTest(classes = JpaAdvancedApplication.class)
class JPQLTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;
	
	@Autowired
	EntityManager entityManager;
	
	
	
	@Test
	public void findById_basic() {
		List resultList = entityManager.createQuery("Select c from Course c").getResultList();
		logger.info("{}", resultList);
	}
	
	
	

}
