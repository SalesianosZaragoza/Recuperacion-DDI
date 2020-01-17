package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Race;

public class RaceAssembler {

	public Race createUserFromRequest(HttpServletRequest request) {

		Race race = new Race();
		race.setSpecie(request.getParameter("Especie"));
		return race;
	}

}
