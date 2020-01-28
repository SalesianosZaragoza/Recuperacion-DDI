package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import es.salesianos.model.Character;

@Component
public class CharacterAssembler {

	public Character createCharacterFromRequest(HttpServletRequest request) {
		Character character = new Character();
		character.setName(request.getParameter("name"));
		character.setCarrier(request.getParameter("carrier"));
		character.setCodRace(request.getParameter("race"));
		return character;
	}
	public Character updateCharacterFromRequest(HttpServletRequest req) {
		String parameterId = req.getParameter("id");
		Integer id = Integer.parseInt(parameterId);
		String name = req.getParameter("name");
		String carrier = req.getParameter("carrier");
		String idRace = req.getParameter("race");
		Character character = new Character();
		character.setId(id);
		character.setName(name);
		character.setCarrier(carrier);
		character.setCodRace(idRace);
		return character;
	}
}
