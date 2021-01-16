package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Student;
import es.salesianos.model.assembler.StudentAssembler;
import es.salesianos.repository.Repository;

public class StudentService {

	private Repository repository = new Repository();
	
	
	public Student assembleStudentFromRequest(HttpServletRequest req) {
		return StudentAssembler.assembleStudentFrom(req);
	}
	
	public void addStudent(Student student) {
		repository.insert(student);
		
	}
	
	public void update(Student student) {
		repository.update(student);
		
	}
	
	public Student search(Integer id) {
		return repository.search(id);
		
	}
}
