package es.salesianos.util;

public abstract class DbQueryConstants {
	//SELECT
	public static final String SELECT_CHARACTER_QUERY = "SELECT * FROM personaje";
	public static final String SELECT_RACE_QUERY = "SELECT * FROM raza";	

	// INSERT
	public static final String INSERT_CHARACTER_QUERY = "INSERT INTO personaje (nombre,portador,codRaza)" + "VALUES (?, ?, ?)";
	public static final String INSERT_RACE_QUERY = "INSERT INTO raza (especie)" + "VALUES (?)";

	// UPDATE
	public static final String UPDATE_CHARACTER_QUERY = "UPDATE personaje  SET nombre=? , portador=?,codRaza=? WHERE id=?";
	public static final String UPDATE_RACE_QUERY = "UPDATE raza  SET especie=? WHERE id=?";

	// DELETE
	public static final String DELETE_CHARACTER_QUERY = "DELETE FROM personaje WHERE id=?";
	public static final String DELETE_RACE_QUERY = "DELETE FROM raza WHERE id=?";
}