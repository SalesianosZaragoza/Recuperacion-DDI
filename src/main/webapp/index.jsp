<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> Inicio </title>
	</head>
	<body>
		<form action="welcome" method="post">
			<span> Nombre: </span> <input type="text" name="name"> <br />
			<span> Raza: </span> <input type="text" name="codRace"> <br />
			<span> Portador: </span> <input type="text" name="bearer"> <br />
			<input type="submit">
		</form>
		<a href="Listed.jsp"> Listado </a> <br />
		<a href="Race.jsp"> Crear Raza </a>
	</body>
</html>