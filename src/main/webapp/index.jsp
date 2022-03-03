<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index page</title>
</head>
<body>
	<form action="/welcome" method="post">
		<span>nombre:</span> <input type="text" name="Nombre"> <br />
		<span>apellido:</span> <input type="text" name="Apellidos"> <br />
		<span>dni:</span> <input type="text" name="DNI"> <br />
		<span>horaEntrada:</span> <input type="time" name="HoraEntrada" min="08:00"> <br />
		<span>horaSalida:</span> <input type="time" name="HoraSalida"  max="21:00"> <br />
		<input type="submit">
	</form>
	<br/>
	<a href="welcome">Listado de alumnos</a>
</body>
</html>