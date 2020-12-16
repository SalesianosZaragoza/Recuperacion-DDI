package es.salesianos.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import es.salesianos.model.Alumno;
import es.salesianos.model.Empresa;
import es.salesianos.model.EmpresaAlumnoDto;

import es.salesianos.service.Service;

public class EditServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;


	private Service service = new Service();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<EmpresaAlumnoDto> listDto = service.listDto();
		req.setAttribute("listDto", listDto);
		
		String nombre = req.getParameter("id");
		Alumno a = new Alumno();
		a.setAsisteFCT(true);
		service.updateAlumno(a);
		
		
		redirect(req,resp);
	}


	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listado.jsp");
		dispatcher.forward(req, resp);
	}
}
