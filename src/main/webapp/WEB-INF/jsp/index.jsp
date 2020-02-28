<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Formulario</title>
	</head>
	<body>
		<span>Insertar raza</span>
		<form action="insertRace" method="post">
			<span>Race:</span> <input type="text" name="specie"><input type="submit" value="Insert race">
		</form>
		<br />
		<span>Insertar personaje</span>
		<form action="insertCharacter" method="post">
			<span>Name:</span> <input type="text" name="name"><span>Race:</span>
			<input type="number" name="codRace" min="0"><span>Ring Bearer:</span>
			<select name="holder">
				<option value="true">Yes</option>
				<option value="false">No</option>
			</select><input type="submit" value="Insert character">
		</form>
		<br>
		<form action="listcharacters" method="post">
			<input type="submit" value="Character List">
		</form> &nbsp;
		<form action="listraces" method="post">
			<input type="submit" value="Races List">
		</form>
	</body>
</html>