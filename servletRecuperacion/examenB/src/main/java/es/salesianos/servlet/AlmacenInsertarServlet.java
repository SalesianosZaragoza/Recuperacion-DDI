package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Almacen;
import es.salesianos.service.AlmacenService;

public class AlmacenInsertarServlet extends HttpServlet{
	
	private AlmacenService service = new AlmacenService();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Almacen almacen = service.createNewEntityFromRequest(req);
		service.insert(almacen);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.sendRedirect("/listadoAlmacenes");
	}
	
}
