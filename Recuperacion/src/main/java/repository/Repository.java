package repository;

import java.util.List;

import model.Warehouse;

@SuppressWarnings("unused")
public interface Repository<E> {
	static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";

	public List<E> listAll();
	
	public void insert(E element);

	public void insertOldWarehouse(E element);
	
	public void insertNewWarehouse(E element);
	
	public void update(E element);

	public E findByIdOldWarehouse(Integer id);
	
	public E findByIdNewWarehouse(Integer id);
	
	public void delete(Integer id);

	public void deleteOldWarehouse(Integer id);
	
	public void deleteNewWarehouse(Integer id);

	

	

	

}
