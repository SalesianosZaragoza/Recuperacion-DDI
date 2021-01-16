package es.salesianos.model.assembler;



import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Student;


public class StudentAssembler {
	
	public static  Student assembleStudentFrom(HttpServletRequest req) {
		Student student = new  Student();
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");			
		String answer=req.getParameter("asisteFCT");
		
		if(answer.equals("SI")) {
			student.setAsisteFCT(true);
		}else 
			student.setAsisteFCT(false);
		
		String empresa=req.getParameter("id");
		
		if(null != empresa) {
			student.setCompany(Integer.parseInt(empresa));
		}
		
		if(null != id) {
			student.setId(Integer.parseInt(id));
		}
		
		if(null != name) {
			student.setName(name);
		}
		
		if(null != age) {
			student.setAge(Integer.parseInt(age));	
		}

		return student;
	}
}

