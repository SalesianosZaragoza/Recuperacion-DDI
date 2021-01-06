package es.salesianos.service;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.Business;
import es.salesianos.model.Student;
import es.salesianos.model.assembler.BusinessAssembler;
import es.salesianos.repository.BusinessRepository;


public class BusinessService {
	private BusinessAssembler assembler = new BusinessAssembler();
	private BusinessRepository repository = new BusinessRepository();
	
	public Business createNewEntityFromRequest(HttpServletRequest req) {
		Business business = assembler.assembleFrom(req);
		return business;
	}
	
	public Business updateEntityFromRequest(HttpServletRequest req) {
		Business business = assembler.assembleFromExistent(req);
		return business;
	}
	
	public void insert(Business business) {
		repository.insert(business);
	}
	public void update(Business business) {
		repository.update(business);
	}
	
	public List<Student> getStudents(Business business) {
		return repository.getStudents(business);
	}
	
	public void delete(Business business, boolean studentsToo) {
		StudentService a_service = new StudentService();
		for (Student student:getStudents(business)) {
			if (studentsToo) {
				a_service.delete(student);					
			} else {
				a_service.setNull(student);
			}
		}
		repository.delete(business);
	}
	
	public Business findById(Integer id) {
		return repository.findById(id);
	}
	
	public List<Business> listAll() {
		return repository.listAll();
	}
}

