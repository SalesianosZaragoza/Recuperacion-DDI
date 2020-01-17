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
		try {
			character.setCodRace(idRace);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return character;
	}
}
