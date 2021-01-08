package com.mycompany.assembler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.mycompany.model.Student;

@Component
public class StudentAssembler {

	public Student createStudentFromRequest(HttpServletRequest request) {

		Student student = new Student();
		student.setName_student(request.getParameter("name_student"));
		student.setAge(request.getParameter("age"));
		student.setFCTasists(request.getParameter("FCTasists"));
		student.setCompany(request.getParameter("company"));
		return student;
	}

}
