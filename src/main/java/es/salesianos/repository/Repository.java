package es.salesianos.repository;

import java.util.List;

public interface Repository<E> {
	
	public List<E> listAll();

	public E findBy(Integer id);

	public void insert(E user);

	public void update(E user);

}
