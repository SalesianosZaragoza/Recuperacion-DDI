package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.CharacterAssembler;
import es.salesianos.model.Character;
import es.salesianos.repository.CharacterRepository;
import es.salesianos.repository.Repository;

@org.springframework.stereotype.Service("characterService")
public class CharacterService implements Service<Character> {

	private CharacterAssembler assembler = new CharacterAssembler();
	private Repository<Character> repository = new CharacterRepository();

	@Override
	public Character createNewDataFromRequest(HttpServletRequest req) {
		Character character = assembler.createCharacterFromRequest(req);
		return character;
	}

	@Override
	public void insert(Character character) {
		repository.insert(character);
	}

	@Override
	public List<Character> listAll() {
		return repository.listAll();
	}

	@Override
	public void update(Character character) {
		repository.update(character);
	}

	@Override
	public void delete(HttpServletRequest req) {
		repository.delete(req);
	}

	@Override
	public Character listById(Integer idCharacter) {
		return repository.selectById(idCharacter);
	}

	@Override
	public Character updateDataFromRequest(HttpServletRequest req) {
		Character character = assembler.updateCharacterFromRequest(req);
		return character;
	}
}
