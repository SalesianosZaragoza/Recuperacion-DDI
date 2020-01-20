package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Character;
import es.salesianos.model.Race;

public interface Service {

	public Character createNewUserFromRequest(HttpServletRequest req);
	
	public Race createNewRaceFromRequest(HttpServletRequest req);

	public void insertCharacter(Character character);
	
	public void insertRace(Race race);

	public List<Character> listAll();
	
	public List<Race> listAllRace();
}