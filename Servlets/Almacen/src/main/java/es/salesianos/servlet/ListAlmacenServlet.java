package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import es.salesianos.model.AlmacenNew;
import es.salesianos.model.AlmacenOld;
import es.salesianos.service.AlmacenNewService;
import es.salesianos.service.AlmacenOldService;

public class ListAlmacenServlet extends HttpServlet {
	private AlmacenNewService servicio = new  AlmacenNewService();
	private AlmacenOldService servicio2 = new  AlmacenOldService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<AlmacenOld> listAllAlmacenesOld = servicio2.listAllAlmacenesOld();
		List<AlmacenNew> listAllAlmacenesNew = servicio.listAllAlmacenesNew();
		req.setAttribute("listAllAlmacenesOld", listAllAlmacenesOld);
		req.setAttribute("listAllAlmacenesNew", listAllAlmacenesNew);
		
		redirect(req,resp);
	}
	
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listAlmacen.jsp");
		dispatcher.forward(req,resp);
	}
}
