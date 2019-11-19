package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.model.UserTeam;

public class UserTeamRepository extends AbstractRepository {
	


	public List<UserTeam> listUserTeam() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ArrayList<UserTeam> users = new ArrayList<UserTeam>();
		try {
			preparedStatement = conn
					.prepareStatement("SELECT u.name as nb, u.apellido as ap, t.nombreEquipo as ne* "
							+ "FROM User u JOIN Team t ON u.codEquipo=t.id");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				UserTeam user = new UserTeam();
				user.setNombreJugador(resultSet.getString("nb"));
				user.setApellido(resultSet.getString("ap"));
				user.setNombreEquipo(resultSet.getString("ne"));
				users.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return users;
	}

}
