<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insertar Almacen</title>
</head>
<body>
	<h1>Inserta un nuevo Almacen</h1><hr />
	<p>Rellena el formulario a continuación.</p>
	<form action="insertarAlmacen" method="post">
		<span>Nombre:</span> 
		<input type="text" name="nombre" required><br />
		<span>Tipo:</span> 
		<select name="oldNew" required>
			<option value="old">Old</option>
			<option value="new">New</option>
		</select><br />
		<input type="submit">
	</form>
	</body>
</html>