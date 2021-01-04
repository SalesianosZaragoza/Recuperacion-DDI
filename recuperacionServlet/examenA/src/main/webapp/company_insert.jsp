<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Insertar Empresa</title>
</head>
<body>	
		<div>			
			<a>Inserta una Empresa</a>		
		<div>
			<p>Rellena el formulario a continuación.</p>
			<form action="insertCompany" method="post">
				<div>
					<label for="name">Nombre:</label>
					<input id="name" type="text" name="name">
				</div>
				<button type="submit">Insertar</button>
			</form>
		</div>
	</div>
	</body>
</html>