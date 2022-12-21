package com.vignesh.jpa.hibernate.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;

import com.vignesh.jpa.hibernate.JpaAdvancedApplication;
import com.vignesh.jpa.hibernate.entity.Course;
import com.vignesh.jpa.hibernate.entity.Review;
import com.vignesh.jpa.hibernate.entity.Student;

@SpringBootTest(classes = JpaAdvancedApplication.class)
class CourseRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;
	
	@Test
	public void findById() {
		Optional<Course> course = repository.findById(10001L);
		logger.info("{}", course.isPresent());
		assertTrue(course.isPresent());

	}
	
	@Test
	public void sort() {

		
		repository.findAll(Sort.by(Sort.Direction.ASC,"name"));

	}
	
	
	


}
