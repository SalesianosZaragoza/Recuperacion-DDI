package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Company;

public class CompanyAssembler {

	public Company assembleFrom(HttpServletRequest req) {
		Company company = new Company(
			req.getParameter("name")
		);
		
		return company;
	}

	public Company assembleFromExistent(HttpServletRequest req) {
		Company student = assembleFrom(req);
		student.setId(Integer.parseInt(req.getParameter("id")));
		return student;
	}
}