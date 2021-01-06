package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.Student;

public class StudentAssembler {

	public Student assembleFrom(HttpServletRequest req) {
		Student student = new Student(
				req.getParameter("name"),
				Integer.parseInt(req.getParameter("age")),
				req.getParameter("assistsFCT").equals("true"),
				(!(req.getParameter("business").equals("null"))) ? Integer.parseInt(req.getParameter("business")) : null
		);
		
		return student;
	}
	
	public Student assembleFromExistent(HttpServletRequest req) {
		Student student = assembleFrom(req);
		student.setId(Integer.parseInt(req.getParameter("id")));
		return student;
	}
}