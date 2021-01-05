package es.salesianos.model.assembler;



import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Alumno;


public class AlumnoAssembler {
	
	public static  Alumno assembleAlumnoFrom(HttpServletRequest req) {
		Alumno user = new  Alumno();
		String name = req.getParameter("name");
		String age = req.getParameter("age");			
		String answer=req.getParameter("asisteFCT");
		
		if(answer.equals("SI")) {
			user.setAsisteFCT(true);
		}else 
			user.setAsisteFCT(false);
		
		String empresa=req.getParameter("id");
		
		if(null != empresa) {
			user.setEmpresa(Integer.parseInt(empresa));
		}
		
		if(null != name) {
			user.setName(name);
		}
		
		if(null != age) {
			user.setEdad(Integer.parseInt(age));	
		}

		return user;
	}
}

