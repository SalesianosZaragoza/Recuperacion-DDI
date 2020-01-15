package es.salesianos.repository;

import java.util.List;

public interface Repository<E> {

	public List<E> listAll();

	public void insert(E element);

	public void update(E element);

	public E findById(Integer id);

}
