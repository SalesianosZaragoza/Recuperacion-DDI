<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insertar Libro</title>
</head>
<body>
	<h1>Inserta un nuevo Libro</h1><hr />
	<p>Rellena el formulario a continuación.</p>
	<form action="insertarLibro" method="post">
		<span>Isbn:</span> 
		<input type="text" name="isbn" required><br />
		<span>Fecha Edición:</span> 
		<input type="date" name="fechaEdicion" required><br />
		<span>Almacen:</span> 
		<select disabled></select><br />
		<input type="submit">
	</form>
	</body>
</html>