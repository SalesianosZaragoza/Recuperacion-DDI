package service2;


import java.util.List;


import model2.Company;
import repository2.Repository;

public class CompanyService implements Service<Company>{

	
	private Repository<Company> repository;
	
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
