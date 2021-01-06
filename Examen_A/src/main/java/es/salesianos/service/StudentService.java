package es.salesianos.service;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Student;
import es.salesianos.model.assembler.StudentAssembler;
import es.salesianos.repository.StudentRepository;

public class StudentService {
	private StudentAssembler assembler = new StudentAssembler();
	private StudentRepository repository = new StudentRepository();
	
	public Student createNewEntityFromRequest(HttpServletRequest req) {
		Student student = assembler.assembleFrom(req);
		return student;
	}
	
	public Student updateEntityFromRequest(HttpServletRequest req) {
		Student student = assembler.assembleFromExistent(req);
		return student;
	}
	
	public void insert(Student student) {
		repository.insert(student);
	}
	
	public void delete(Student student) {
		repository.delete(student);
	}
	
	public void setNull(Student student) {
		repository.setNull(student);
	}
	
	public void update(Student student) {
		repository.update(student);
	}
	
	public Student findById(Integer id) {
		return repository.findById(id);
	}
	
	public List<Student> listAll() {
		return repository.listAll();
	}
}
