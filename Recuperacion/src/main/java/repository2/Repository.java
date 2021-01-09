package repository2;

import java.util.List;

public interface Repository<E> {
	static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";

	public List<E> listAll();

	public void insert(E element);

	public void update(E element);

	public E findById(Integer id);

	public void delete(Integer id);

}

