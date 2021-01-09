package service2;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("unused")
public interface Service<E> {

	public void insert(E element);

	public List<E> listAll();

	public void delete(Integer id);

}
