package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import es.salesianos.model.Empresa;
import es.salesianos.service.EmpresaService;

public class ListEmpresaServlet extends HttpServlet {
	private EmpresaService servicio = new  EmpresaService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Empresa> listAllEmpresa = servicio.listAllEmpresa();		
		req.setAttribute("listAllEmpresa", listAllEmpresa);
		redirect(req,resp);
	}
	
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listAlmacen.jsp");
		dispatcher.forward(req,resp);
	}
}
