package service2;

import java.util.List;


import model2.Student;
import repository2.Repository;

public class StudentService implements Service<Student>{


	private Repository<Student> repository;
	

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
