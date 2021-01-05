package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.AlmacenNew;

public class AlmacenNewAssembler {

	public static AlmacenNew assembleAlmacenNewFrom(HttpServletRequest req) {
		AlmacenNew almacen = new AlmacenNew();
		String nombre = req.getParameter("name");
		almacen.setName(nombre);

		return almacen;
	}
}