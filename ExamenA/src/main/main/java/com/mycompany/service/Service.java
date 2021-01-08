package com.mycompany.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mycompany.model.Student;
import com.mycompany.model.Company;
import com.mycompany.model.FCTCompany;
import com.mycompany.repository.Repository;

public class Service {

private Repository repository = new Repository();



	public void insert(Company company) {
		repository.insert(company);
	}

	public Company getCompany() {
		return repository.getCompany();
	}

	public void insert(Student student) {	
		repository.insert(student);
	}

	public List<FCTCompany> listFct() {
		return repository.listAllFct();
	}

	public void updateStudent(Student) {
				 repository.updateStudent();

	}

}
