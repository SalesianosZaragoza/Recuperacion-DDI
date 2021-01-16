package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Student;
import es.salesianos.service.StudentService;

public class EditStudentServlet extends HttpServlet{
StudentService service = new StudentService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Student student= new Student();
		student.setId(Integer.parseInt(id));
		Student studentFromDatabase = service.search(student.getId());
		req.setAttribute("student", studentFromDatabase);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/studentEdited.jsp");
		dispatcher.forward(req,resp);
	}
}
