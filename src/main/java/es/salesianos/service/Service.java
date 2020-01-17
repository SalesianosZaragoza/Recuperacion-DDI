package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.LordOfTheRingsCharacter;
import es.salesianos.model.Race;

public interface Service<E> {

	public E createNewUserFromRequest(HttpServletRequest req);

	public void insert(E user);

	public List<E> listAll();
	
	public E listById(Integer id);

}
