package es.salesianos.assembler;

import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.Character;

public class CharacterAssembler {

	public Character createCharacterFromRequest(HttpServletRequest request) {
		Character character = new Character();
		character.setName(request.getParameter("name"));
		character.setCarrier(request.getParameter("carrier"));
		try {
			character.setCodRace(request.getParameter("race"));
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return character;
	}
}
