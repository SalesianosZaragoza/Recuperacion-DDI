package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.salesianos.assembler.CharacterAssembler;
import es.salesianos.model.Character;
import es.salesianos.repository.Repository;

@Component
public class CharacterService implements Service {
	@Autowired
	private CharacterAssembler assembler;

	@Autowired
	private Repository<Character> repository;

	public Character createNewCharacterFromRequest(HttpServletRequest req) {
		Character character = assembler.createCharacterFromRequest(req);
		return character;
	}
	
	public void insertCharacter(Character character) {
			repository.insert(character);
	}

	@Override
	public List<Character> listAll() {
		return repository.listAll();
	}

	public Character listById(Integer idCharacter) {
		return repository.findBy(idCharacter);
	}

	public void update(Character character) {
		repository.update(character);
	}

	public Repository<Character> getRepository() {
		return repository;
	}

	public void setRepository(Repository<Character> repository) {
		this.repository = repository;
	}
	

}
