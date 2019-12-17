package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.salesianos.assembler.UserAssembler;
import es.salesianos.model.User;
import es.salesianos.repository.Repository;

@Component
public class UserService implements Service {
	@Autowired
	private UserAssembler assembler;

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

<<<<<<< HEAD
	public Repository<User> getRepository() {
		return repository;
	}

	public void setRepository(Repository<User> repository) {
		this.repository = repository;
	}
=======
	
>>>>>>> 84f294532a77d2027c0c80fb50ef4e48f3dfddef

}
