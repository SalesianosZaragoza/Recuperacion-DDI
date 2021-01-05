package es.salesianos.model.assembler;



import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.Libro;

public class LibroAssembler {
	
	public static  Libro assembleLibroFrom(HttpServletRequest req) {
		Libro user = new  Libro();
		String isbn = req.getParameter("isbn");
		String fechaEdicion = req.getParameter("fechaEdicion");
		if(null != fechaEdicion) {
			user.setFechaEdicion(fechaEdicion);
		}		
		String almacenOld=req.getParameter("idOld");
		if(null != almacenOld) {
			user.setAlmacenOld(Integer.parseInt(almacenOld));
		}		
		String almacenNew=req.getParameter("idNew");
		if(null != almacenNew) {
			user.setAlmacenNew(Integer.parseInt(almacenNew));
		}
		
		user.setIsbn(isbn);

		return user;
	}
}

