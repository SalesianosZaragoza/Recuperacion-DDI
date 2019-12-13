package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.User;

public class UserAssembler {

	public User createUserFromRequest(HttpServletRequest request) {

		User user = new User();
		user.setNombre(request.getParameter("nombre"));
		user.setApellido(request.getParameter("apellido"));
		user.setDni(request.getParameter("dni"));
		return user;
	}

}
