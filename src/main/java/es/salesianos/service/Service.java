package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Character;
import es.salesianos.model.Race;

public interface Service<E> {

	public E createNewFromRequest(HttpServletRequest req);

	public void insert(E element);

	public List<E> listAll();

	public void update(E element);

} 