package modelAssembler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.Book;

public class BookAssembler {
	public static Book assemblerBookFrom(HttpServletRequest req) {
		Book book = new Book();
		
		String isbn = req.getParameter("isbn");
		String date = req.getParameter("editionDate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date convert = null;
		try {
			convert = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		book.setIsbn(isbn);
		book.setEditionDate(convert);

		Integer storehouse;
		if(req.getParameter("storehouse") == "oldStorehouse") {
			storehouse = Integer.parseInt(req.getParameter("old"));
			book.setNewStorehouse(null);
			book.setOldStorehouse(storehouse);
		} else if (req.getParameter("storehouse") == "newStorehouse") {
			storehouse = Integer.parseInt(req.getParameter("new"));
			book.setOldStorehouse(null);
			book.setNewStorehouse(storehouse);
		}
		
		return book;
	}
}
