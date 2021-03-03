package es.salesianos.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Business;
import es.salesianos.model.Student;
import es.salesianos.service.StudentService;

public class StudentDeleteServlet extends HttpServlet{
	
	private StudentService service = new StudentService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Student student = service.findById(id);
		service.delete(student);
		redirect(req,resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.sendRedirect("/studentList");
	}
	
}
