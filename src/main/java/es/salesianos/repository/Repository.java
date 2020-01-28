package es.salesianos.repository;

import java.util.List;
@org.springframework.stereotype.Repository
public interface Repository<E> {
	//METODOS A IMPLEMENTAR
	public List<E> listAll();

	public void insert(E element);

	public void update(E element);
	
	public void delete(Integer id);

	E selectById(Integer idCharacter);
}
