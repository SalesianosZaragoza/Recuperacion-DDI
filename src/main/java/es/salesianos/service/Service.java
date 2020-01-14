package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Character;

public interface Service {

	public Character createNewUserFromRequest(HttpServletRequest req);

	public void insertUser(Character user);

	public List<Character> listAll();

}
