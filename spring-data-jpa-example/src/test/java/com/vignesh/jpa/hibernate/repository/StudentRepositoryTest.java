package com.vignesh.jpa.hibernate.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.vignesh.jpa.hibernate.JpaAdvancedApplication;
import com.vignesh.jpa.hibernate.entity.Passport;
import com.vignesh.jpa.hibernate.entity.Student;

@SpringBootTest(classes = JpaAdvancedApplication.class)
class StudentRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager em;
	
	//session / session factory
	//entity manager/persistence context
	//transaction
	
	@Test
	@Transactional //persistence context
	public void someTest() {
		repository.someDummyOperation(); 
	}
	
	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student-{}", student);
		logger.info("passport-{}",student.getPassport());
	}
	
	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudent() {
		Passport passport = em.find(Passport.class, 40001L);
		logger.info("passport-{}", passport);
		logger.info("student-{}",passport.getStudent());
	}
	
	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		
		Student student = em.find(Student.class, 20001L);
		logger.info("student-{}", student);
		logger.info("courses-{}", student.getCourses());
		
//		Passport passport = em. 
	}
	
	
	

}
