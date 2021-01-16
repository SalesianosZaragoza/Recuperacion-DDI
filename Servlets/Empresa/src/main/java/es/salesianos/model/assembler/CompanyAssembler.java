package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Company;

public class CompanyAssembler {

	public static Company assembleCompanyFrom(HttpServletRequest req) {
		Company company = new Company();
		String name = req.getParameter("name");
		company.setName(name);

		return company;
	}
}