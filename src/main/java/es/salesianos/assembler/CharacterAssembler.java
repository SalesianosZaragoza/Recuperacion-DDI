package es.salesianos.assembler;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.LordOfTheRingsCharacter;;

public class CharacterAssembler {

	public LordOfTheRingsCharacter createUserFromRequest(HttpServletRequest request) {

		LordOfTheRingsCharacter character = new LordOfTheRingsCharacter();
		character.setCharacterName(request.getParameter("nombre"));
		character.setRingBearer(request.getParameter("portador"));
		character.setCodRace(request.getParameter("codRaza"));
		return character;
	}

}
