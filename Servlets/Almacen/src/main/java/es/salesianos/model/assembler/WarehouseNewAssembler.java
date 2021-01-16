package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.WarehouseNew;

public class WarehouseNewAssembler {

	public static WarehouseNew assembleWarehouseNewFrom(HttpServletRequest req) {
		WarehouseNew warehouseNew = new WarehouseNew();
		String name = req.getParameter("name");
		warehouseNew.setName(name);

		return warehouseNew;
	}
}