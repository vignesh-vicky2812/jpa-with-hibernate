package com.vignesh.jpa.hibernate.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vignesh.jpa.hibernate.entity.Course;

@Repository
@Transactional
public class CourseRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entityManager;

	public Course findById(Long id) {
		return entityManager.find(Course.class, id);
	}

	public Course save(Course course) {
		if (course.getId() == null) {
			entityManager.persist(course);
		} else { 
			entityManager.merge(course);
		}
		return course;
	}

	public void deleteById(Long id) {
		Course course = findById(id);
		entityManager.remove(course);
	}
	public void playWithEntityManager() {
		Course course1 = new Course("Web services in 100 steps");
		entityManager.persist(course1);
		Course course2 = new Course("Angular JS in 100 steps");
		entityManager.persist(course2);
		entityManager.flush();
		
//		entityManager.detach(course1);
//		entityManager.detach(course2);
//		//or
//		entityManager.clear();
		
		
		course1.setName("Web services in 100 steps - updated");
		course2.setName("Angular JS in 100 steps - updated");
		
		entityManager.refresh(course1);;
		entityManager.flush();
	
		
	}
}
