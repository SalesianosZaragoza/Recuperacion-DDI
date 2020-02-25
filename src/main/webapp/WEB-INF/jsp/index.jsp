<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Formulario</title>
	</head>
	<body style="text-align: center; margin-top: 15px">
		<form action="insertRace" method="post">
			<span>Raza:</span> <input type="text" name="specie"> &nbsp; <input type="submit" value="Insertar raza">
		</form>
		<br />
		<form action="insertCharacter" method="post">
			<span>Nombre:</span> <input type="text" name="name"> &nbsp; <span>Raza:</span>
			<input type="number" name="codRace" min="0"> &nbsp; <span>Portador:</span>
			<select name="holder">
				<option value="true">Sí</option>
				<option value="false">No</option>
			</select> &nbsp; <input type="submit" value="Insertar personaje">
		</form>
		<br>
		<form action="listcharacters" method="post">
			<input type="submit" value="Ver el listado de personajes">
		</form> &nbsp;
		<form action="listraces" method="post">
			<input type="submit" value="Ver el listado de especies">
		</form>
	</body>
</html>