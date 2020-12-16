package es.salesianos.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Almacen;
import es.salesianos.service.AlmacenService;

public class AlmacenBorrarServlet extends HttpServlet{
	
	private AlmacenService service = new AlmacenService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		Integer id = Integer.parseInt(req.getParameter("id"));
		Almacen almacen = null;
		if (type.equals("old")) {
			almacen = service.findByIdOld(id);
		} else if (type.equals("new")) {
			almacen = service.findByIdNew(id);
		}
		service.delete(almacen);
		redirect(req,resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.sendRedirect("/listadoAlmacenes");
	}
	
}
