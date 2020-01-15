package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Character;

public class CharacterAssembler {

	public Character createCharacterFromRequest(HttpServletRequest request) {

		Character character = new Character();
		character.setName(request.getParameter("name"));
		character.setHolder(Boolean.parseBoolean(request.getParameter("holder")));
		character.setCodRace(Long.parseLong(request.getParameter("race")));

		return character;
	}

}
