<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario</title>
</head>
<body>
	<form action="welcomeRace" method="post">
		<span>Raza:</span> <input type="text" name="specie"> <br /> <input
			type="submit" value="Insertar raza">
	</form>
	<br />
	<br />
	<form action="welcomeCharacter" method="post">
		<span>Nombre:</span> <input type="text" name="name"> <br /> <span>Raza:</span>
		<input type="number" name="race" min="0"> <br /> <span>Portador:</span>
		<select name="holder">
			<option value="true">Sí</option>
			<option value="false">No</option>
		</select> <br /> <input type="submit" value="Insertar personaje">
	</form>
	<br>
	<a href="listCharacters">Ver listado de personajes</a>
	<a href="listRaces">Ver listado de razas</a>
</body>
</html>