package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Student;

public class StudentAssembler {

	public Student assembleFrom(HttpServletRequest req) {
		Student student = new Student(
				req.getParameter("name"),
				Integer.parseInt(req.getParameter("age")),
				req.getParameter("asistFCT").equals("true"),
				(!(req.getParameter("company").equals("null"))) ? Integer.parseInt(req.getParameter("company")) : null
		);
		
		return student;
	}

	public Student assembleFromExistent(HttpServletRequest req) {
		Student student = assembleFrom(req);
		student.setId(Integer.parseInt(req.getParameter("id")));
		return student;
	}
}