package es.salesianos.repository;

import java.util.List;

public interface Repository<E> {
	
	static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	//METODOS A IMPLEMENTAR
	public List<E> listAll();

	public void insert(E element);

	public void update(E element);
	
	public void delete(Integer id);

	E selectById(Integer idCharacter);
}
