package es.salesianos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import es.salesianos.model.Character;
import es.salesianos.repository.Repository;

@org.springframework.stereotype.Service("characterService")
public class CharacterService implements Service<Character> {

	@Autowired
	@Qualifier("characterRepository")
	private Repository<Character> repository;

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
	public void delete(Integer id) {
		repository.delete(id);
	}

	@Override
	public Character listById(Integer idCharacter) {
		return repository.selectById(idCharacter);
	}

}
