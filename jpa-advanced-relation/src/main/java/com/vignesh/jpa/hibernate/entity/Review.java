package com.vignesh.jpa.hibernate.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
//@NamedQueries(value = { @NamedQuery(name = "query_allcourses", query = "Select c from Course c"),
//		@NamedQuery(name = "query_100_step", query = "Select c from Course c where name like '%100 Steps'") })
public class Review {

	@Id
	@GeneratedValue
	private Long id;

	private String rating;
	
	private String description;
	
	@ManyToOne
	private Course course;

	
	private Review() {

	}


	public Review(String rating, String description) {
		super();
		this.rating = rating;
		this.description = description;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", description=" + description + "]";
	}
	

	

}
