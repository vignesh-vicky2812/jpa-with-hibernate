package com.vignesh.jpa.hibernate.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vignesh.jpa.hibernate.entity.Passport;
import com.vignesh.jpa.hibernate.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entityManager;

	public Student findById(Long id) {
		return entityManager.find(Student.class, id);
	}

	public Student save(Student student) {
		if (student.getId() == null) {
			entityManager.persist(student);
		} else {
			entityManager.merge(student);
		}
		return student;
	}

	public void saveStudentWithPassport() {
		Passport passport = new Passport("A123999");
		entityManager.persist(passport);
		Student student = new Student("Mike");
		student.setPassport(passport);
		entityManager.persist(student);
	}

	public void someDummyOperation() {
		Student student = entityManager.find(Student.class, 20001L);

		Passport passport = student.getPassport();

		passport.setNumber("E111111");

		student.setName("Vingesh updated");
	}

}
