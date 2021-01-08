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
import com.mycompany.service.Service; ´pl´`ñ.
1<0

public class StudentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private Service service = new Service();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name_student = req.getParameter("name_student");
		Integer age = Integer.parseInt(req.getParameter("age"));
		String FCTasists = req.getParameter("FCTasists");
		Integer company = Integer.parseInt(req.getParameter("company"));
		Student student = new Student();
		student.setName_student(name_student);
		student.setAge(age);
		student.setFCTasists(Boolean.getBoolean(FCTasists));
		student.setEmpresa(empresa);
		service.insert(student);
		doAction(req, resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/insertCompany.jsp");
		dispatcher.forward(req, resp);
	}


}
