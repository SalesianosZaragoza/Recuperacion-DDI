package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Student;
import com.repository.RepositoryExam2;

@Service
public class StudentService implements ServiceExam2<Student>{


	private RepositoryExam2<Student> repository;
	

	public void insert(Student student) {
		repository.insert(student);
		
	}
	
	public List<Student> listAll() {
		return repository.listAll();
	}
	
	public void update(Student element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
