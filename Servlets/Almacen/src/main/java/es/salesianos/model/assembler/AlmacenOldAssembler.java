package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.AlmacenOld;

public class AlmacenOldAssembler {

	public static AlmacenOld assembleAlmacenOldFrom(HttpServletRequest req) {
		AlmacenOld user = new AlmacenOld();
		String nombre = req.getParameter("name");
		user.setName(nombre);

		return user;
	}
}