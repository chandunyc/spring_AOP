package com.ds.dao;

 

import org.springframework.jdbc.core.JdbcTemplate;

import com.ds.dto.Student;

public class StudentDaoImpl implements StudentDao {

	JdbcTemplate jdbcTemplate = null;

	@Override
	public String insertStudent(Student student) {
		// TODO Auto-generated method stub
		String query = "";
		query = "insert into std values(" + student.getSid() + ",'" + student.getSname() + "');";
		int rs = jdbcTemplate.update(query);
		if (rs == 1) {

			return "Student is inserted";

		} else {

			return "Student insertion failure";
		}
	}

	@Override
	public String deleteStudent(int sid) {
		String query = "";
		query = "delete from std where sid="+sid+ ";";
		int rs = jdbcTemplate.update(query);
		if (rs == 1) {

			return "Student is deleted";

		} else {

			return "Student deletion failure";
		}
	}

	@Override
	public Student searchStudent(int sid) {
		// TODO Auto-generated method stub
		String query = "";
		Student s1=null;
		try
		{
		query = "select * from std where sid="+sid+ ";";
		s1 = jdbcTemplate.queryForObject(query,new StudentMapper());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		return s1;
	}

	@Override
	public String updateStudent(Student std) {
		String query = "";
		query = "update std set sname='"+std.getSname()+"' where sid="+std.getSid()+ ";";
		int rs = jdbcTemplate.update(query);
		if (rs == 1) {

			return "Student update success";

		} else {

			return "Student update failure";
		}
	}

	@Override
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated method stub
		this.jdbcTemplate = jdbcTemplate;

	}

}
