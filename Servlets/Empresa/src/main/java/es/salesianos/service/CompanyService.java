package es.salesianos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Company;
import es.salesianos.repository.Repositoryy;

@Service
public class CompanyService {
	
	@Autowired 
	private Repositoryy repository;
	
	public void addCompany(Company company) {
		repository.insert(company);
	}
	
	public void deleteCompany(Integer id, String answer) {
		repository.delete(id,answer);
	}
	
	public List<Company> listAllCompany() {		
		return repository.searchAllCompany();
	}
	

}
