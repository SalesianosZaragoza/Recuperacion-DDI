package controller2;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;



import connection.AbstractConnection;
import connection.H2Connection;
import model.Book;
import model.Warehouse;
import model2.Company;
import model2.Student;
import repository2.Repository;
import service2.Service;




public class Controller<ModelAndView> { 


	private Service<Student> studentService;
	

	private Service<Company> companyService;


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
		return company();
	}
	
	
	protected ModelAndView deleteStudent(Integer id) {
		studentService.delete(id);
		return student();
	}
	
}
