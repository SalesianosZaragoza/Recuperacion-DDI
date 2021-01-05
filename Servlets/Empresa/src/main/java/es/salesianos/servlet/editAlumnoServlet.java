package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Alumno;
import es.salesianos.service.AlumnoService;

public class editAlumnoServlet extends HttpServlet{
AlumnoService service = new AlumnoService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Alumno ownerFormulario= new Alumno();
		ownerFormulario.setId(Integer.parseInt(id));
		Alumno ownerFromDatabase = service.search(ownerFormulario.getId());
		req.setAttribute("alumno", ownerFromDatabase);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/alumnoEdited.jsp");
		dispatcher.forward(req,resp);
	}
}
