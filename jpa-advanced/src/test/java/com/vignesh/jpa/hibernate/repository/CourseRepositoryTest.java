package com.vignesh.jpa.hibernate.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.vignesh.jpa.hibernate.JpaAdvancedApplication;
import com.vignesh.jpa.hibernate.entity.Course;

@SpringBootTest(classes = JpaAdvancedApplication.class)
class CourseRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;
	
	
	
	@Test
	public void findById_basic() {
		Course course = repository.findById(10002L);
		assertEquals("Spring in 50 steps", course.getName());
//		logger.info("Testing is running");
	}
	
	@Test
	@DirtiesContext
	public void deleteById_basic() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));
		
	}
	
	@Test
	@DirtiesContext
	public void save_basic() {
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 steps", course.getName());
		
		//update details
		course.setName("JPA in 50 steps - Updated");
		repository.save(course);
		
		Course course1 = repository.findById(10001L);
		assertEquals("JPA in 50 steps - Updated", course1.getName());

	}
	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		repository.playWithEntityManager();

	}
	

}
