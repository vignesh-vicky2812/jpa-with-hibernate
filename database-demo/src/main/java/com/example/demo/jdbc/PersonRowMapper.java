package com.example.demo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.entity.Person;

class PersonRowMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person = new Person(rs.getInt("id"), rs.getString("name"), rs.getString("location"),
				rs.getTimestamp("birth_date"));
		return person;
	}

}