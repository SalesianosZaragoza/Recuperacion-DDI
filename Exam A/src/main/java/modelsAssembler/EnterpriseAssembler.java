package modelsAssembler;

import javax.servlet.http.HttpServletRequest;

import models.Enterprise;

public class EnterpriseAssembler {
	public Enterprise assembleUserFrom(HttpServletRequest req) {
		Enterprise enterprise = new Enterprise();
		String nombre = req.getParameter("name");

		enterprise.setName(nombre);

		return enterprise;
	}
}
