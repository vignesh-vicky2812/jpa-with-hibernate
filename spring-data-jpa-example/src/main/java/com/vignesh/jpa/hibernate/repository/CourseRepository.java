package com.vignesh.jpa.hibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vignesh.jpa.hibernate.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	List<Course> countByName(String name);
	List<Course> findByNameOrderByIdDesc(String name);

	
	
}
