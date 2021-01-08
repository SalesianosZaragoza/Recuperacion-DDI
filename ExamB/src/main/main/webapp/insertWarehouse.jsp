<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert warehouse</title>
</head>
<body>
< background-image: url(https://img.freepik.com/vector-gratis/fondo-tecnologia-digital-alambre-malla-red_1017-27428.jpg?size=626&ext=jpgmariposa_p.png)">

<form method="post" action="/InsertWarehouse">
    
<div>
					<span for="name">Name:</span>
					<input id="name" type="text" name="name" required>
				</div>
				<div>
					<span for="oldNew">Type:</span>
					<select id="oldNew" name="oldNew" required>
						<option value="old">Old</option>
						<option value="new">New</option>
					</select>
				</div>
				<button type="submit">Insert</button>
			</form>
		</div>

</body>
</html>