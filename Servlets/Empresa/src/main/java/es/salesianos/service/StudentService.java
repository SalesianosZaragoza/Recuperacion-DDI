package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Student;
import es.salesianos.repository.Repositoryy;

@Service
public class StudentService {

	@Autowired 
	private Repositoryy repository;
	
	public void insert(Student student) {
		repository.insert(student);
	}
	
	public void update(Student student) {
		repository.update(student);
	}
	
	public Student searchStudent(Integer id) {
		return repository.searchStudent(id);	
	}

	public List<Student> searchAll() {
		return repository.searchAllStudent();
	}
}
