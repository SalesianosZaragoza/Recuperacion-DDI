package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Warehouse;

public class WarehouseAssembler {

	public Warehouse assembleFrom(HttpServletRequest req) {
		Warehouse warehouse = new Warehouse(
				req.getParameter("name"),
				req.getParameter("oldNew").equals("old")
		);

		return warehouse;
	}
}