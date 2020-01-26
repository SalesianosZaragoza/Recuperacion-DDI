package es.salesianos.util;

import org.springframework.stereotype.Component;

@Component
public abstract class DbQueryConstants {
	//SELECT
	public static final String SELECT_ALL_CHARACTER = "SELECT * FROM personaje INNER JOIN raza "
			+ "ON personaje.codRaza =  raza.id";
	public static final String SELECT_ALL_RACE = "SELECT * FROM raza";
	public static final String SELECT_CHARACTER_BY_ID = "SELECT * FROM personaje WHERE id=?";
	public static final String SELECT_RACE_BY_ID = "SELECT * FROM raza WHERE id=?";

	// INSERT
	public static final String INSERT_CHARACTER = "INSERT INTO personaje (nombre,portador,codRaza)" + "VALUES (?, ?, ?)";
	public static final String INSERT_RACE = "INSERT INTO raza (especie)" + " VALUES (?)";

	// UPDATE
	public static final String UPDATE_CARRIER = "UPDATE personaje SET portador='NO'";
	public static final String UPDATE_CHARACTER = "UPDATE personaje SET nombre=? , portador=?,codRaza=? WHERE id=?";
	public static final String UPDATE_RACE = "UPDATE raza SET especie=? WHERE id=?";

	// DELETE
	public static final String DELETE_CHARACTER = "DELETE FROM personaje WHERE id=?";
	public static final String DELETE_RACE = "DELETE FROM raza WHERE id=?";
	public static final String DELETE_CHARACTER_BY_RACE = "DELETE FROM personaje WHERE codRaza=?";
}