package es.salesianos.assembler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Character;
import es.salesianos.repository.AbstractRepository;

public class CharacterAssembler extends AbstractRepository {
	private String portador;

	public String checkPortador() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
				.prepareStatement("SELECT p.ID, COUNT (p.ID) AS Cantidad FROM PERSONAJE p WHERE p.PORTADOR=TRUE");
			preparedStatement.executeQuery();
			portador = preparedStatement.toString();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return portador;
	}

	public Character createCharacterFromRequest(HttpServletRequest request) {
		Character character = new Character();
		if (portador == "1" && request.getParameter("holder") != "false")
			throw new RuntimeException("Solo puede haber un portador");
		character.setName(request.getParameter("name"));
		character.setHolder(Boolean.parseBoolean(request.getParameter("holder")));
		character.setCodRace(Long.parseLong(request.getParameter("codRace")));

		return character;
	}
}
