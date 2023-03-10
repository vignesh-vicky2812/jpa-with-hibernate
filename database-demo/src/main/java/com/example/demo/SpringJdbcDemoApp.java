package com.example.demo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Person;
import com.example.demo.jdbc.PersonJdbcDao;

//@SpringBootApplication
public class SpringJdbcDemoApp implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", dao.findAll());
		logger.info("User id 10001 -> {}", dao.findById(10001));
		logger.info("Deleting 10002 -> no. of rows deleted - {}", dao.deleteById(10002));
		logger.info("Inserting 10004 -> {}", dao.insert(new Person(10004, "Naruto", "japan", new Date())));
		logger.info("Updating 10003 -> {}", dao.update(new Person(10003, "Peter", "USA", new Date())));
		
	}

}
