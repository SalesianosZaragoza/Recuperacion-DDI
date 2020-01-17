<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index page</title>
</head>
<body>
	<h4>Insertar raza</h4>
	<form action="insertRace" method="post">
		<span>Raza:</span> <input type="text" name="specie"> <br /> <input
			type="submit" value="Insertar raza">
	</form>
	<br />
	<br />
	<h4>Insertar personaje</h4>
	<form action="insertCharacter" method="post">
		<span>Nombre:</span> <input type="text" name="name"> 
		<br /> 
		<span>Raza:</span>
		<input type="text" name="race"> 
		<br /> 
		<span>Portador:</span>
		<select name="bearer">
			<option value="SI">SI</option>
			<option value="NO">NO</option>
		</select> <br /> <input type="submit" value="Insertar personaje">
	</form>
	<a href="CharacterList.jsp">Ver el listado de personajes</a>
	<a href="RaceList.jsp">Ver el listado de razas</a>
</body>
</html>