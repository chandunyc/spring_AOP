package com.ds.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ds.dao.StudentDao;
import com.ds.dto.Student;

public class Test {
	public static void main(String args[]) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/ds/resources/applicationContext.xml");
		StudentDao studentdao = (StudentDao) context.getBean("stdao");
		Student stdd = new Student();
		stdd.setSid(7);
		stdd.setSname("chandu7");
		String sts = studentdao.insertStudent(stdd);
		System.out.println(sts);
		
		stdd=studentdao.searchStudent(1);
		if(stdd!=null)
		{
		System.out.println("student details are");
		System.out.println(stdd.getSid());
		System.out.println(stdd.getSname());
		}
		else
		{
			System.out.println("student not found");
		}
		
		/*
		Student stdd2 = new Student();
		stdd2.setSid(3);
		stdd2.setSname("yamini2");
		
		
		String sts = studentdao.insertStudent(stdd);
		System.out.println(sts);
		String st2=studentdao.deleteStudent(2);
		System.out.println(st2);
		stdd=studentdao.searchStudent(3);
		System.out.println("student details are");
		System.out.println(stdd.getSid());
		System.out.println(stdd.getSname());
		
		String st3=studentdao.updateStudent(stdd2);
		System.out.println(st3);
		
		stdd=studentdao.searchStudent(3);
		System.out.println("student details are");
		System.out.println(stdd.getSid());
		System.out.println(stdd.getSname());
		*/
		
	}

}
