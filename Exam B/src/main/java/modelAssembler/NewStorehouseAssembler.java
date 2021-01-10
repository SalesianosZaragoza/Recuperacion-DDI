package modelAssembler;

import javax.servlet.http.HttpServletRequest;

import model.NewStorehouse;

public class NewStorehouseAssembler {

	public static NewStorehouse assemblerNewStorehouseFrom(HttpServletRequest req) {
		NewStorehouse storehouse = new NewStorehouse();
		String name = req.getParameter("name");

		storehouse.setName(name);
		return storehouse;
	}
}
