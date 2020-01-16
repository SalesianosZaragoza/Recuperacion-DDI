<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index page</title>
</head>
<body>
	<form action="welcome" method="post">
		<span>Name:</span> <input type="text" name="name"> <br />
		<span>Age:</span> <input type="number" name="age"> <br />
		<span>Holder:</span> <input type="checkbox" name="holder"> <br />
		<input type="submit">
	</form>
	<a href="List.jsp">List</a>
</body>
</html>