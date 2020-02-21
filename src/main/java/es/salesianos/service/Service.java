package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface Service<E> {

	public void insert(E element);

	public List<E> listAll();

	public void update(E element);
	
	public void delete(HttpServletRequest req);

}