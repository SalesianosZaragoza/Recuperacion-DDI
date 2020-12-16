package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Almacen;

public class AlmacenAssembler {

	public Almacen assembleFrom(HttpServletRequest req) {
		Almacen almacen = new Almacen(
				req.getParameter("nombre"),
				req.getParameter("oldNew").equals("old")
		);
		
		return almacen;
	}
	
	public Almacen assembleFromExistent(HttpServletRequest req) {
		Almacen almacen = assembleFrom(req);
		almacen.setId(Integer.parseInt(req.getParameter("id")));
		return almacen;
	}
}