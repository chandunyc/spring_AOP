package com.ds.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ds.dto.Student;

public class StudentMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rno) throws SQLException {
		// TODO Auto-generated method stub
		Student std=new Student();
		std.setSid(rs.getInt("sid"));
		std.setSname(rs.getString("sname"));
		return std;
		
	
	}

}
