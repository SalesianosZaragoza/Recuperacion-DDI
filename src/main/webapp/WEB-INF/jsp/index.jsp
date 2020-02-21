<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome page</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cosmo/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
				<form action="insertCharacter" method="post">
					<label>Name:</label> <input type="text" name="name"> <br />
					<label>Ring Bearer:</label> 
					<select name="ringBearer">
						<option value="YES">YES</option>
						<option value="NO">NO</option>
					</select> 
					<label>Race Code:</label> <input type="text" name="race">
					<br />
					<input type="submit"
						value="Insert character">
				</form>
				<a href="ListCharacters">Show the full list of characters</a>
				<br />
				<form action="insertRace" method="post">
					<label>Race:</label> <input type="text" name="specie"><br />
					<input type="submit" value="Insert race">
				</form>
				<br />
				<a href="ListRaces">Show the full list of races</a>

</body>
</html>