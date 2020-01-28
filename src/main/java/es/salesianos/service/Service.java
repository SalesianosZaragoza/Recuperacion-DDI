package es.salesianos.service;

import java.util.List;
@org.springframework.stereotype.Service
public interface Service<E> {

	public void insert(E user);

	public List<E> listAll();
	
	public void update(E element);
	
	public void delete(Integer id);

	public E listById(Integer id);

}
