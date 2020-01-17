package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Character;

public class CharacterAssembler {

	public Character createUserFromRequest(HttpServletRequest request) {

		Character character = new Character();
		character.setName(request.getParameter("name"));
		character.setBearer(request.getParameter("bearer"));
		character.setCodRace(Integer.parseInt(request.getParameter("codRace")));
		return character;
	}
}