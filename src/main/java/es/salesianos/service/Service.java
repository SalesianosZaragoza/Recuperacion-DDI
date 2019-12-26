package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Character;
import es.salesianos.model.Race;

public interface Service {

	public Character createNewCharacterFromRequest(HttpServletRequest req);
	
	public Race createNewRaceFromRequest(HttpServletRequest req);

	public void insertCharacter(Character user);
	
	public void insertRace(Race user);

	public List<Character> listCharacters();
	
	public List<Race> listRaces();

}
