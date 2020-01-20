package es.salesianos.repository;

import java.util.List;

import es.salesianos.model.Race;

public interface Repository<E> {
	
	public List<E> listAll();

	public E findBy(Integer id);

	public void insert(E element);

	public void update(E element);

	//public void insert(Race race);
}