package com.controller;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.connection.AbstractConnection;
import com.connection.H2Connection;
import com.model.Book;
import com.model.Company;
import com.model.Student;
import com.model.Warehouse;
import com.repository.RepositoryExam2;
import com.service.ServiceExam2;



@Controller
public class ControllerExam2<ModelAndView> { 


	private ServiceExam2<Student> studentService;
	

	private ServiceExam2<Company> companyService;


	public String getIndexPage() {
		return "index";
	}

	
	public String getListStudentPage() {
		return "liststudents";
	}

	

	public String getListCompanyPage() {
		return "listCompany";
	}
	

	public String insertStudent(Student student) {
		studentService.insert(student);
		return "welcomeStudent";
	}


	public String insertCompany(Company company) {
		companyService.insert(company);
		return "welcomeCompany";
	}
	


	protected ModelAndView deleteCompany(Integer id) {
		companyService.delete(id);
		return deleteCompany(id);
	}
	
	
	protected ModelAndView deleteStudent(Integer id) {
		studentService.delete(id);
		return deleteStudent(id);
	}
	
}
