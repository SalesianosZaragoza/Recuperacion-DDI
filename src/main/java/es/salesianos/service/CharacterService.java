package es.salesianos.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import es.salesianos.assembler.CharacterAssembler;
import es.salesianos.repository.CharacterRepository;
import es.salesianos.repository.Repository;
import es.salesianos.model.Character;
import es.salesianos.model.Race;

public class CharacterService implements Service<Character> {

	private CharacterAssembler assembler = new CharacterAssembler();
	private Repository<Character> repository = new CharacterRepository();
	
	public CharacterService() {

	}
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
	public Character listById(Integer idCharacter) {
		return repository.selectById(idCharacter);
	}
	public Character updateDataFromRequest(HttpServletRequest req) {
		Character character = assembler.updateCharacterFromRequest(req);
		return character;
	}
}
