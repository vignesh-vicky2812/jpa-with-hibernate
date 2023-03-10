package com.example.demo;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Person;
import com.example.demo.jpa.PersonJpaRepository;

@SpringBootApplication
public class JpaDemoApp implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", repository.findAll());
		logger.info("User id 10001 -> {}", repository.findById(10001));
		logger.info("Inserting 10004 -> {}", repository.insert(new Person(10004, "Naruto", "japan", new Date())));
		logger.info("Updating 10003 -> {}", repository.update(new Person(10003, "Peter", "USA", new Date())));
		repository.deleteById(10002);
	}

}
