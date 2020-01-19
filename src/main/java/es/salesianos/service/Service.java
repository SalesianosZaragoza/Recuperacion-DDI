package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface Service<E> {
	
	public E createNewDataFromRequest(HttpServletRequest req);

	public void insert(E user);

	public List<E> listAll();
	
	public void update(E element);
	
	public void delete(HttpServletRequest req);

	public E listById(Integer id);

	public E updateDataFromRequest(HttpServletRequest req);

}
