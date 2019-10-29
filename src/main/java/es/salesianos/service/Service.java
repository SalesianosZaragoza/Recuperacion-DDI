package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.User;

public interface Service {

	public User createNewUserFromRequest(HttpServletRequest req);

	public void insertUser(User user);

	public List<User> listAll();

}
