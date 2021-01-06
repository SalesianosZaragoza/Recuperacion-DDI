package es.salesianos.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Business;
import es.salesianos.model.Student;
import es.salesianos.service.BusinessService;
import es.salesianos.service.StudentService;

public class StudentInsertServlet extends HttpServlet{
	
	private BusinessService e_service = new BusinessService();
	private StudentService service = new StudentService();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student student = service.createNewEntityFromRequest(req);
		service.insert(student);
		dredirect(req,resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Business> business = e_service.listAll();
		req.setAttribute("business", business);
		redirect(req,resp);
	}
	
	protected void dredirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.sendRedirect("/studentList");
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/student_insert.jsp");
		dispatcher.forward(req,resp);
	}
}
