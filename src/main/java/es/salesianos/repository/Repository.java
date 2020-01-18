package es.salesianos.repository;

import java.util.List;

public interface Repository<E> {

	public List<E> listAll();

	public E findBy(Integer id);

	public void insert(E element);

	public void update(E element);

}