package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Character;

public interface Service {

	public Character createNewCharacterFromRequest(HttpServletRequest req);

	public void insertCharacter(Character character);

	public List<Character> listAll();

}
