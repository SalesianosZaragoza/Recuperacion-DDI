package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.salesianos.assembler.CharacterAssembler;
import es.salesianos.model.Character;
import es.salesianos.repository.Repository;

@Component
public class UserService implements Service {
	@Autowired
	private CharacterAssembler assembler;

	@Autowired
	private Repository<Character> repository;

	public Character createNewUserFromRequest(HttpServletRequest req) {
		Character user = assembler.createUserFromRequest(req);
		return user;
	}
	
	public void insertUser(Character user) {
			repository.insert(user);
	}

	@Override
	public List<Character> listAll() {
		return repository.listAll();
	}

	public Character listById(Integer idUser) {
		return repository.findBy(idUser);
	}

	public void update(Character user) {
		repository.update(user);
	}

	public Repository<Character> getRepository() {
		return repository;
	}

	public void setRepository(Repository<Character> repository) {
		this.repository = repository;
	}
	

}
