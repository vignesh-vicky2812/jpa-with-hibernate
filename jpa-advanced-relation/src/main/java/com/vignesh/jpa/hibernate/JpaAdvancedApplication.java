package com.vignesh.jpa.hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vignesh.jpa.hibernate.entity.FullTimeEmployee;
import com.vignesh.jpa.hibernate.entity.PartTimeEmployee;
import com.vignesh.jpa.hibernate.entity.Review;
import com.vignesh.jpa.hibernate.entity.Student;
import com.vignesh.jpa.hibernate.repository.CourseRepository;
import com.vignesh.jpa.hibernate.repository.EmployeeRepository;
import com.vignesh.jpa.hibernate.repository.StudentRepository;

@SpringBootApplication
public class JpaAdvancedApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaAdvancedApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Review> reviews = new ArrayList<>();
		reviews.add(new Review("5", "Great hand on"));

		reviews.add(new Review("5", "super"));
//		Course course = repository.findById(10001L);
//		logger.info("Course ->{}", course);
////		courseRepository.deleteById(10001L);
//		courseRepository.save(new Course("Microservices in 100 steps"));
		
//		courseRepository.playWithEntityManager();
//		studentRepository.saveStudentWithPassport();
		
//		courseRepository.addReviewsForCourse();
//		courseRepository.addReviewsForCourse(10003L, reviews);
		
		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));

		employeeRepository.insert(new FullTimeEmployee("Jung", new BigDecimal("10000")));
		
		logger.info("all employees {}", employeeRepository.retrieveAllEmployees());
	}

}
