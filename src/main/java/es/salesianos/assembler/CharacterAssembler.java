package es.salesianos.assembler;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Character;
import es.salesianos.repository.AbstractRepository;

public class CharacterAssembler extends AbstractRepository {

	public Character createCharacterFromRequest(HttpServletRequest request) {
		Character character = new Character();
		character.setName(request.getParameter("name"));
		character.setRingPerson(request.getParameter("ringPerson"));
		try {
			character.setCodRace(request.getParameter("race"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return character;
	}

	public Character updateCharacterFromRequest(HttpServletRequest req) {
		String parameterId = req.getParameter("id");
		Integer ID = Integer.parseInt(parameterId);
		String name = req.getParameter("name");
		String codRace = req.getParameter("race");
		String ringPerson = req.getParameter("ringPerson");
		Character character = new Character();
		character.setId(ID);
		character.setRingPerson(ringPerson);
		character.setName(name);
		try {
			character.setCodRace(codRace);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return character;
	}
} 
