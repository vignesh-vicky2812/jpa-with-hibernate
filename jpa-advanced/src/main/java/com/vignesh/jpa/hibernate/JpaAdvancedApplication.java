package com.vignesh.jpa.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vignesh.jpa.hibernate.entity.Course;
import com.vignesh.jpa.hibernate.repository.CourseRepository;

@SpringBootApplication
public class JpaAdvancedApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaAdvancedApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Course course = repository.findById(10001L);
//		logger.info("Course ->{}", course);
////		repository.deleteById(10001L);
//		repository.save(new Course("Microservices in 100 steps"));
		
		repository.playWithEntityManager();
	}

}
