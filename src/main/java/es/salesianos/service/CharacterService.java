package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import es.salesianos.assembler.CharacterAssembler;
import es.salesianos.model.LordOfTheRingsCharacter;
import es.salesianos.repository.Repository;

public class CharacterService implements Service<LordOfTheRingsCharacter> {

	private CharacterAssembler assembler = new CharacterAssembler();

	public CharacterService() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	
	private Repository<LordOfTheRingsCharacter> characterRepository;

	public LordOfTheRingsCharacter createNewUserFromRequest(HttpServletRequest req) {
		LordOfTheRingsCharacter character = assembler.createUserFromRequest(req);
		return character;
	}
	
	public void insert(LordOfTheRingsCharacter character) {
			characterRepository.insert(character);
	}

	
	public List<LordOfTheRingsCharacter> listAll() {
		return characterRepository.listAll();
	}

	public LordOfTheRingsCharacter listById(Integer idCharacter) {
		return characterRepository.listByUser(idCharacter);
	}

	public void update(LordOfTheRingsCharacter character) {
		characterRepository.update(character);
	}
}
