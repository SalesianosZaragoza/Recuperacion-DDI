package es.salesianos.repository;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Repository<E> {
	
	public List<E> listAll();

	public void insert(E element);

	public void update(E element);
	
	public void delete(HttpServletRequest req)throws ServletException, IOException;

}
