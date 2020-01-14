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
	public void insert(Character character) {
		Connection connection = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement("INSERT INTO Character(name, age, holder)" + "VALUES (?, ?, ?)");
			preparedStatement.setString(1, character.getName());
			preparedStatement.setInt(2, character.getAge());
			preparedStatement.setBoolean(3, character.getHolder());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(connection);
		}

	}

	public List<Character> listAll() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ArrayList<Character> characters = new ArrayList<Character>();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM Character");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Character character = new Character();
				character.setId(resultSet.getInt("id"));
				character.setName(resultSet.getString("name"));
				character.setAge(resultSet.getInt("age"));
				character.setHolder(resultSet.getBoolean("holder"));
				characters.add(character);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return characters;
	}

	public Character listByCharacter(Integer idCharacter) {
		Connection connection = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		Character character;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM Character WHERE id = ?");
			preparedStatement.setInt(1, idCharacter);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			character = new Character();
			character.setId(resultSet.getInt("id"));
			character.setName(resultSet.getString("name"));
			character.setAge(resultSet.getInt("age"));
			character.setHolder(resultSet.getBoolean("holder"));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(connection);
		}
		return character;
	}

	public void update(Character character) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE Character SET name = ?, age = ?, holder = ? WHERE id = ?");
			preparedStatement.setString(1, character.getName());
			preparedStatement.setInt(2, character.getAge());
			preparedStatement.setBoolean(3, character.getHolder());
			preparedStatement.setInt(4, character.getId());
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
		Connection connection = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		Character character;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM Character WHERE id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			character = new Character();
			character.setId(resultSet.getInt("id"));
			character.setName(resultSet.getString("name"));
			character.setAge(resultSet.getInt("age"));
			character.setHolder(resultSet.getBoolean("holder"));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(connection);
		}
		return character;
	}

}
