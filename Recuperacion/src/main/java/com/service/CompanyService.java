package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Company;
import com.repository.RepositoryExam2;

@Service
public class CompanyService implements ServiceExam2<Company>{

	
	private RepositoryExam2<Company> repository;
	
	@Override
	public void insert(Company company) {
		repository.insert(company);
		
	}

	@Override
	public List<Company> listAll() {
		return repository.listAll();
	}


	@Override
	public void delete(Integer id) {
		repository.delete(id);
		
	}


}
