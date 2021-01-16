package es.salesianos.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.Company;
import es.salesianos.model.assembler.CompanyAssembler;
import es.salesianos.repository.Repository;

public class CompanyService {
	
	
	private Repository repository = new Repository();
	
	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}
	
	public Company assembleCompanyFromRequest(HttpServletRequest req) {
		return CompanyAssembler.assembleCompanyFrom(req);
	}
	
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
