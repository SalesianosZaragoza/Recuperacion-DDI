package es.salesianos.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Student;
import es.salesianos.model.assembler.StudentAssembler;
import es.salesianos.service.StudentService;

public class UpdateStudentServlet extends HttpServlet{
	StudentService service = new StudentService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student student = StudentAssembler.assembleStudentFrom(req);
		service.update(student);
		redirect(req, resp);
	}
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listCompany.jsp");
		dispatcher.forward(req,resp);
	}
}
