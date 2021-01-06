package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Business;

public class BusinessAssembler {

	public Business assembleFrom(HttpServletRequest req) {
		Business business = new Business(
				req.getParameter("name")
		);	
		return business;
	}
	
	public Business assembleFromExistent(HttpServletRequest req) {
		Business business = assembleFrom(req);
		business.setId(Integer.parseInt(req.getParameter("id")));
		return business;
	}
}