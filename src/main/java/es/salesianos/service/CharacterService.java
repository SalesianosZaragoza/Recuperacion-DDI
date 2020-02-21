package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import es.salesianos.repository.CharacterRepository;
import es.salesianos.model.Character;

@org.springframework.stereotype.Service("characterService")
public class CharacterService implements Service<Character> {

	@Autowired
	@Qualifier("characterRepository")
	private CharacterRepository repository = new CharacterRepository();

	public void insert(Character character) {
		repository.insert(character);
	}

	public List<Character> listAll() {
		return repository.listAll();
	}

	public void update(Character character) {
		repository.update(character);
	}
	
	public Character findBy(Integer id) {
		return repository.findBy(id);
	}

	@Override
	public void delete(HttpServletRequest req) {
		repository.delete(req);
	}
	
}