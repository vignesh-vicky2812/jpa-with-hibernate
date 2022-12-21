package com.vignesh.jpa.hibernate.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
//@NamedQueries(value = { @NamedQuery(name = "query_allcourses", query = "Select c from Course c"),
//		@NamedQuery(name = "query_100_step", query = "Select c from Course c where name like '%100 Steps'") })
public class Passport {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String number;
	
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy = "passport")
	private Student student;
	

	
	public Passport() {

	}

	

	public Passport(String number) {
		super();
		this.number = number;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Student getStudent() {
		return student;
	}



	public void setStudent(Student student) {
		this.student = student;
	}



	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + ", student=" + student + "]";
	}

}
