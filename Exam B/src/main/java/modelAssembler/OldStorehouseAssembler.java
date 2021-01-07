package modelAssembler;

import javax.servlet.http.HttpServletRequest;

import model.OldStorehouse;

public class OldStorehouseAssembler {

	public static OldStorehouse assemblerOldStorehouseFrom(HttpServletRequest req) {
		OldStorehouse oldStorehouse = new OldStorehouse();

		String name = req.getParameter("name");

		oldStorehouse.setName(name);
		return oldStorehouse;
	}
}
