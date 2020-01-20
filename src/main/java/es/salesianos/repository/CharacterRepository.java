package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.salesianos.model.Character;


@Component
public class CharacterRepository extends AbstractRepository implements Repository<Character> {

	public void insert(Character userFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		String isBearer = userFormulario.getBearer();
		if(isBearer.equalsIgnoreCase("si")) {
			try {
				preparedStatement = conn.prepareStatement("UPDATE CHARACTER SET bearer = ?");
				preparedStatement.setString(1, "no");
				preparedStatement.executeUpdate();
				System.out.println("CHECK" + isBearer);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO CHARACTER (name,codRace,bearer)" + "VALUES (?, ?, ?)");
			preparedStatement.setString(1, userFormulario.getName());
			preparedStatement.setInt(2, userFormulario.getCodRace());
			preparedStatement.setString(3, userFormulario.getBearer());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}

	public List<Character> listAll() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ArrayList<Character> characteres = new ArrayList<Character>();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM CHARACTER");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Character character = new Character();
				character.setId(resultSet.getInt("id"));
				character.setName(resultSet.getString("name"));
				character.setCodRace(resultSet.getInt("codRace"));
				character.setBearer(resultSet.getString("bearer"));
				characteres.add(character);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return characteres;

	}

	public Character listByPersonaje(Integer idCharacter) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		Character character;
		
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM CHARACETER WHERE id=?");
			preparedStatement.setInt(1, idCharacter);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			character = new Character();
			character.setId(resultSet.getInt("id"));
			character.setName(resultSet.getString("name"));
			character.setCodRace(resultSet.getInt("codRace"));
			character.setBearer(resultSet.getString("bearer"));

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return character;
	}

	public void update(Character user) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatementBearer = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			preparedStatement = conn.prepareStatement("UPDATE CHARACTER SET name=? , codRace=?, bearer=? WHERE id=?");
			preparedStatement.setString(1, user.getName());
			preparedStatement.setInt(2, user.getCodRace());
			preparedStatement.setString(3, user.getBearer());
			preparedStatement.setInt(4, user.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

	@Override
	public Character findBy(Integer id) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		Character character;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM CHARACTER  WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			character = new Character();
			character.setId(resultSet.getInt("id"));
			character.setName(resultSet.getString("name"));
			character.setCodRace(resultSet.getInt("codRace"));
			character.setBearer(resultSet.getString("bearer"));

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return character;
		
	}


}