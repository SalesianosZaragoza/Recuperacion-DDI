package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import es.salesianos.assembler.UserAssembler;
import es.salesianos.model.User;
import es.salesianos.repository.Repository;

public class UserService implements Service {

	private UserAssembler assembler = new UserAssembler();

	@Autowired
	private Repository<User> repository;

	public User createNewUserFromRequest(HttpServletRequest req) {
		User user = assembler.createUserFromRequest(req);
		return user;
	}
	
	public void insertUser(User user) {
			repository.insert(user);
	}

	@Override
	public List<User> listAll() {
		return repository.listAll();
	}

	public User listById(Integer idUser) {
		return repository.findBy(idUser);
	}

	public void update(User user) {
		repository.update(user);
	}

}
