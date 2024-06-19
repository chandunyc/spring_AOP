package com.ds.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ds.dto.Student;

public interface StudentDao {

	public String insertStudent(Student student);
	public String deleteStudent(int sid);
	public Student searchStudent(int sid);
	public String updateStudent(Student std);	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate);
	
}	
