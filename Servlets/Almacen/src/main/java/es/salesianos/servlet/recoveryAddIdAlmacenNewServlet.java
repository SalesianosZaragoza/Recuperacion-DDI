package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.AlmacenNew;
import es.salesianos.service.AlmacenNewService;


public class recoveryAddIdAlmacenNewServlet extends HttpServlet{
	AlmacenNewService service = new AlmacenNewService();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		AlmacenNew almacenForm= new AlmacenNew();
		almacenForm.setId(Integer.parseInt(id));
		req.setAttribute("almacen", almacenForm);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addLibroNew.jsp");
		dispatcher.forward(req,resp);
	}
}
