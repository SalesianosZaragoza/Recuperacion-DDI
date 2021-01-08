package com.mycompany.assembler;

import javax.servlet.http.HttpServletRequest;

import com.mycompany.model.Book;

@Component
public class BookAssembler {

	public Book assembleFromFromRequest(HttpServletRequest request) {

		Book book = new Book();
		request.setISBN(request.getParameter("ISBN"));
		request.setDateEdition(request.getParameter("DateEdition"));
		request.getParameter("newWarehouse") != null) ? Integer.parseInt(request.getParameter("newWarehouse")) : null,
		(request.getParameter("oldWarehouse") != null) ? Integer.parseInt(request.getParameter("oldWarehouse")) : null);
		return book;
	}
	public Book assembleFromExistent(HttpServletRequest request) {
		Book book = assembleFrom(request);
		book.setId(Integer.parseInt(request.getParameter("id")));
		return book;
	}

}
