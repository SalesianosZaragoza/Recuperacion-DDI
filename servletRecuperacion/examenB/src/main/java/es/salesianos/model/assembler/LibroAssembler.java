package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Libro;

public class LibroAssembler {

	public Libro assembleFrom(HttpServletRequest req) {
		Libro libro = new Libro(
				req.getParameter("isbn"),
				req.getParameter("fechaEdicion"),
				(req.getParameter("almacenes_old") != null) ? Integer.parseInt(req.getParameter("almacenes_old")) : null,
				(req.getParameter("almacenes_new") != null) ? Integer.parseInt(req.getParameter("almacenes_new")) : null
		);
		
		return libro;
	}
	
	public Libro assembleFromExistent(HttpServletRequest req) {
		Libro libro = assembleFrom(req);
		libro.setId(Integer.parseInt(req.getParameter("id")));
		return libro;
	}
}