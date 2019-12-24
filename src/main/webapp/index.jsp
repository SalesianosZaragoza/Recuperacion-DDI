<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insertar datos</title>
</head>
<body>
	<form action="raza" method="post">
		<span>Especie:</span> <input type="text" name="specie"> <br />
		<input type="submit">
	</form>

	<form action="character" method="post">
		<span>Nombre:</span> <input type="text" name="name"> <br />
		<span>Raza:</span> <input type="number" name="race" min="0"> <br />
		<span>Portador:</span> <select name="carrier">
			<option value="YES">YES</option>
			<option value="NO">NO</option>
		</select> <br /> <input type="submit">
	</form>
</body>
</html>