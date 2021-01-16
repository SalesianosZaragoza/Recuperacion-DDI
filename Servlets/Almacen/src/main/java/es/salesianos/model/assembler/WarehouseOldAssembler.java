package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.WarehouseOld;

public class WarehouseOldAssembler {

	public static WarehouseOld assembleWarehouseOldFrom(HttpServletRequest req) {
		WarehouseOld warehouseOld = new WarehouseOld();
		String name = req.getParameter("name");
		warehouseOld.setName(name);

		return warehouseOld;
	}
}