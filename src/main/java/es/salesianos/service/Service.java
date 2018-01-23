package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.User;

public interface Service {

	public User createNewUserFromRequest(HttpServletRequest req);

	public void insertUser(User user);

}
