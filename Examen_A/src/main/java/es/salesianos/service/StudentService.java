package es.salesianos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Student;
import es.salesianos.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired 
	private StudentRepository repository;
	
	public void insert(Student student) {
		repository.insert(student);
	}
	
	public void delete(Integer id) {
		repository.delete(id);
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
