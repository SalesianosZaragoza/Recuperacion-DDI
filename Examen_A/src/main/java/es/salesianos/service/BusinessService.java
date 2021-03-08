package es.salesianos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Business;
import es.salesianos.model.Student;
import es.salesianos.repository.BusinessRepository;

@Service
public class BusinessService {
	@Autowired 
	private BusinessRepository repository;

	public void insert(Business business) {
		repository.insert(business);
	}
	
	public void update(Business businessForm) {
		repository.update(businessForm);
	}
	
	public List<Student> getStudents(Business business) {
		return repository.getStudents(business);
	}
	
	public void delete(Integer id) {
		repository.delete(id);
	}
	
	public Business findById(Integer id) {
		return repository.findById(id);
	}
	
	public List<Business> listAll() {
		return repository.listAll();
	}
}

