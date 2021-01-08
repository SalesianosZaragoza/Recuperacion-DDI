package com.mycompany.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.company.model.Student;

public interface Service {  //Deben ser lo más generica posible

	public Student createNewStudentFromRequest(HttpServletRequest req);

	public void insertStudent(Student student);

	public List<Student> listAll();

}
