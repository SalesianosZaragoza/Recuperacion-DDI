package es.salesianos.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Character;
import es.salesianos.model.Race;

public interface Service<E> {
	
	public E createNewDataFromRequest(HttpServletRequest req);

	public void insert(E user);

	public List<E> listAll();
	
	public void update(E element);
	
	public void delete(HttpServletRequest req);

	public E listById(Integer id);

	public E updateDataFromRequest(HttpServletRequest req);

}
