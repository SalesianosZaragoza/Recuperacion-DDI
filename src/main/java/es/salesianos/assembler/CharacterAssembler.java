package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import es.salesianos.model.Character;

@Component
public class CharacterAssembler {

	public Character createCharacterFromRequest(HttpServletRequest request) {
		Character character = new Character();
		character.setName(request.getParameter("name"));
		character.setAge(Integer.parseInt(request.getParameter("age")));
		character.setHolder(Boolean.parseBoolean(request.getParameter("holder")));
		// The method "getParameter(...)" returns a String, setAge and setHolder require a parse
		return character;
	}

}
