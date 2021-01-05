package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Empresa;

public class EmpresaAssembler {

	public static Empresa assembleEmpresaFrom(HttpServletRequest req) {
		Empresa user = new Empresa();
		String name = req.getParameter("name");
		user.setName(name);

		return user;
	}
}