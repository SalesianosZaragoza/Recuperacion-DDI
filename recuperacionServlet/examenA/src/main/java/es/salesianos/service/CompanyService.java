package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Student;
import es.salesianos.model.Company;
import es.salesianos.model.assembler.CompanyAssembler;
import es.salesianos.repository.CompanyRepository;

public class CompanyService {
	private CompanyAssembler assembler = new CompanyAssembler();
	private CompanyRepository repository = new CompanyRepository();
	
	public Company createNewEntityFromRequest(HttpServletRequest req) {
		Company student = assembler.assembleFrom(req);
		return student;
	}
	
	public Company updateEntityFromRequest(HttpServletRequest req) {
		Company student = assembler.assembleFromExistent(req);
		return student;
	}
	
	public void insert(Company company) {
		repository.insert(company);
	}
	
	public List<Student> getStudents(Company company) {
		return repository.getStudents(company);
	}
	
	public void delete(Company company, boolean alumnosTambien) {
		StudentService a_service = new StudentService();
		for (Student student:getStudents(company)) {
			if (alumnosTambien) {
				a_service.delete(student);					
			} else {
				a_service.setNull(student);
			}
		}
		repository.delete(company);
	}
	
	public Company findById(Integer id) {
		return repository.findById(id);
	}
	
	public List<Company> listAll() {
		return repository.listAll();
	}
}
