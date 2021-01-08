package com.mycompany.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.model.Student;
import com.mycompany.repository.Repository;

public class FCTCompanyService {

	@Autowired
	private Repository<student> repository;

}
