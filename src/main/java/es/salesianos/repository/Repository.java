package es.salesianos.repository;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Character;

public interface Repository<E> {
	//METODOS A IMPLEMENTAR
	public List<E> listAll();

	public void insert(E element);

	public void update(E element);
	
	public void delete(HttpServletRequest req);

	E selectById(Integer idCharacter);
}
