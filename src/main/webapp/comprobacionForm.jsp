<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Comprobación Horarios</title>
</head>
<body>
<h1>Comprobación de entrada del alumno</h1>
	<form action="/validation" method="post">
		<span>DNI:</span> <input type="text" name="DNI">
		<input type="submit" value="Buscar!">
	</form>
	<br/>
    <br/>
    <a href="welcome">Listado de alumnos</a>
</body>
</html>