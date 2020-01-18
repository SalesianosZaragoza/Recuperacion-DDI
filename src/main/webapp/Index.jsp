<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Lord of the rings</title>
<h1>The Lord of the rings</h1>
<h3>Insert data about the character and / or race</h3>
</head>
<body>

	<form action="welcomeCharacter" method="post">
	<h4>Character:</h4>
	<span>Name:</span> <input type="text" name="name"> 
	<br>
	<span>Race:</span><input type="number" name="race" min="0"> 
	<br>
	<span>Ring Bearer:</span>
	<select name="ringBearer">
		<option value="YES">YES</option>
		<option value="NO">NO</option>
	</select> 
	<br>
	<input type="submit" value="insertCharacter">
	</form>

		<form action="welcomeRace" method="post">
	<h4>Race:</h4>
	<span>Race name:</span> <input type="text" name="specie"> 
	<br>
	<input type="submit" value="insertRace">
    <br></br>
	</form>

	<br></br>
	<a href="ListCharacter">Show the full list of characters</a>
	<br>
	<a href="ListRaces">Show the full list of races</a>
</body>
</html>