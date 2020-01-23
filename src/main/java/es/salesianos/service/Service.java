package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Character;
import es.salesianos.model.Race;
import es.salesianos.model.RaceCharacter;

public interface Service  {

	public Character createNewUserFromRequest(HttpServletRequest req);
	
	public Race createNewRaceFromRequest(HttpServletRequest req);

	public void insertCharacter(Character character);
	
	public void insertRace(Race race);

	public List<Character> listAll();
	
	public List<RaceCharacter> listAllRace();
	
	public void deleteCharacter(Character character);
	
	public void deleteRace(Race race);
	
	public Character updateDataFromRequest(HttpServletRequest req);

	public List<Race> listAll2();
}