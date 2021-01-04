<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insertar Almacen</title>
</head>
<body>
	<div>
		<div>
			<p>Rellena el formulario a continuación.</p>
			<form action="insertWarehouse" method="post">
				<div>
					<span for="name">Nombre:</span> 
					<input id="name" type="text" name="name" required>
				</div>
				<div>
					<span for="oldNew">Tipo:</span> 
					<select id="oldNew" name="oldNew" required>
						<option value="old">Old</option>
						<option value="new">New</option>
					</select>
				</div>
				<button type="submit">Insertar</button>
			</form>
		</div>
	</div>
</body>
</html>