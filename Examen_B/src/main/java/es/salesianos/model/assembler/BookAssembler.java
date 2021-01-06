package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Book;

public class BookAssembler {
	public Book assembleFrom(HttpServletRequest req) {
		Integer warehouseId;
		boolean isWarehouseOld = false;
		if (req.getParameter("oldWarehouses") != null) {
			warehouseId = Integer.parseInt(req.getParameter("oldWarehouses"));
			isWarehouseOld = true;
		} else {
			warehouseId = Integer.parseInt(req.getParameter("newWarehouses"));
		}
		
		Book book = new Book(
				req.getParameter("isbn"),
				req.getParameter("editionDate"),
				warehouseId,
				isWarehouseOld
		);
		return book;
	}
}