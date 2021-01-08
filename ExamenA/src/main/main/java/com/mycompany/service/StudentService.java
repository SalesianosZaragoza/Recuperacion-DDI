package com.mycompany.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.assembler.StudentAssembler;
import com.mycompany.model.Student;
import com.mycompany.repository.Repository;

@Component
public class StudentService implements Service {
	@Autowired
	private StudentAssembler assembler;

	@Autowired
	private Repository<Student> repository;

	public Student createNewStudentFromRequest(HttpServletRequest req) {
		Student student = assembler.createStudentFromRequest(req);
		return student;
	}
	
	public void insertStudent(Student student) {
			repository.insert(student);
	}

	@Override
	public List<Student> listAll() {
		return repository.listAll();
	}

	public Student listById(Integer idStudent) {
		return repository.findBy(idStudent);
	}

	public void update(Student student) {
		repository.update(student);
	}

	public Repository<Student> getRepository() {
		return repository;
	}

	public void setRepository(Repository<Student> repository) {
		this.repository = repository;
	}
	

}
