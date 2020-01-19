package es.salesianos.repository;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface Repository<E> {
	//METODOS A IMPLEMENTAR
	public List<E> listAll();

	public void insert(E element);

	public void update(E element);
	
	public void delete(HttpServletRequest req);

	E selectById(Integer idCharacter);
}
