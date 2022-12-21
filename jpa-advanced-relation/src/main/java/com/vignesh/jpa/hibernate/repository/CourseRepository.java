package com.vignesh.jpa.hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vignesh.jpa.hibernate.entity.Course;
import com.vignesh.jpa.hibernate.entity.Review;
import com.vignesh.jpa.hibernate.entity.Student;

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

		entityManager.refresh(course1);
		;
		entityManager.flush();

	}

	public void addReviewsForCourse() {
		Course course = findById(10003L);

		Review review1 = new Review("5", "Great hands on");
		Review review2 = new Review("4", "Hats off");

		course.addReview(review1);
		review1.setCourse(course);

		course.addReview(review2);
		review2.setCourse(course);

		entityManager.persist(review1);
		entityManager.persist(review2);

	}

	public void addReviewsForCourse(Long courseId, List<Review> reviews) {
		Course course = findById(courseId);

		for (Review review : reviews) {

			course.addReview(review);
			review.setCourse(course);

			entityManager.persist(review);
		}

	}
}
