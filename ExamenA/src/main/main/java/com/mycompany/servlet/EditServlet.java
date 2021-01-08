package com.mycompany.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.model.Student;
import com.mycompany.model.Company;
import com.mycompany.model.FCTCompany;
import com.mycompany.service.Service;

public class EditServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	private Service service = new Service();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<FCTCompany> listFct = service.listFct();
		req.setAttribute("listFct", listFct);
		
		String name = req.getParameter("name");
		Student student = new Student();
		student.setFCTasists(true);
		service.updateStudent(student);

		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/list.jsp");
		dispatcher.forward(req, resp);
	}

}
