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

public class StudentEditServlet extends HttpServlet{
	
	private StudentService service = new StudentService();
	private BusinessService business_service = new BusinessService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student student = service.updateEntityFromRequest(req);
		service.update(student);
		dredirect(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Student student = service.findById(id);
		req.setAttribute("student", student);
		List<Business> business = business_service.listAll();
		req.setAttribute("business", business);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/student_edit.jsp");
		dispatcher.forward(req,resp);
	}
	
	protected void dredirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.sendRedirect("/studentList");
	}

}