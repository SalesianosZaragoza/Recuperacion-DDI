package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Empresa;
import es.salesianos.service.EmpresaService;

public class recoveryAddIdEmpresaServlet extends HttpServlet{
	EmpresaService service = new EmpresaService();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Empresa empresaForm= new Empresa();
		empresaForm.setId(Integer.parseInt(id));
		req.setAttribute("empresa", empresaForm);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addAlumno.jsp");
		dispatcher.forward(req,resp);
	}
}
