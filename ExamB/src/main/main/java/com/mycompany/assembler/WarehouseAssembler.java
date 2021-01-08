package com.mycompany.assembler;

import javax.servlet.http.HttpServletRequest;

import com.mycompany.model.warehouse;

public class WarehouseAssembler {

	public Warehouse assembleFrom(HttpServletRequest req) {
		Warehouse warehouse = new Warehouse(
	req.getParameter("name"),
	req.getParameter("oldNew").equals("old")
	);

		return warehouse;
	}

	public Almacen assembleFromExistent(HttpServletRequest req) {
		Warehouse warehouse = assembleFrom(req);
		warehouse.setId(Integer.parseInt(req.getParameter("id")));
		return warehouse;
	}
} 