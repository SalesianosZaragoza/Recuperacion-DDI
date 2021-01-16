package es.salesianos.model.assembler;



import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.Book;

public class BookAssembler {
	
	public static  Book assembleBookFrom(HttpServletRequest req) {
		Book book = new  Book();
		String isbn = req.getParameter("isbn");
		String dateEdition = req.getParameter("dateEdition");
		if(null != dateEdition) {
			book.setDateEdition(dateEdition);
		}		
		String warehouseOld=req.getParameter("idOld");
		if(null != warehouseOld) {
			book.setWarehouseOld(Integer.parseInt(warehouseOld));
		}		
		String warehouseNew=req.getParameter("idNew");
		if(null != warehouseNew) {
			book.setWarehouseNew(Integer.parseInt(warehouseNew));
		}
		
		book.setIsbn(isbn);

		return book;
	}
}

