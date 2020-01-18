package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.CharacterAssembler;
import es.salesianos.model.Character;
import es.salesianos.repository.CharacterRepository;

public class CharacterService implements Service<Character> {
	private CharacterAssembler assembler = new CharacterAssembler();
	private CharacterRepository repository = new CharacterRepository();

	public Character createNewFromRequest(HttpServletRequest req) {
		Character character = assembler.createCharacterFromRequest(req);
		return character;
	}

	public void insert(Character character) {
		repository.insert(character);
	}

	public List<Character> listAll() {
		return repository.listAll();
	}

	public void update(Character character) {
		repository.update(character);
	}

	public Character findById(Integer id) {
		return repository.findById(id);
	}
}
