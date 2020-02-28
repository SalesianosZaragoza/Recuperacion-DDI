<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
body {
    background-image: url("img/background.jpg");
}
</style>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Formulario</title>
	</head>
	<body>
		<span>Insert race</span>
		<form action="insertRace" method="post">
			<span>Race:</span> <input type="text" name="specie"><input type="submit" value="Insert race">
		</form>
		<br />
		<span>Insert character</span>
		<form action="insertCharacter" method="post">
			<span>Name:</span> <input type="text" name="name"><span>Race:</span>
			<input type="number" name="codRace" min="0"><span>Ring Bearer:</span>
			<select name="holder">
				<option value="true">Yes</option>
				<option value="false">No</option>
			</select><input type="submit" value="Insert character">
		</form>
		<br>
		<span>List of characters</span>
		<form action="listcharacters" method="post">
			<input type="submit" value="Character List">
		</form>
		<span>List of races</span>
		<form action="listraces" method="post">
			<input type="submit" value="Races List">
		</form>
		<img src="img/meme1.jpg" id="meme1">
	</body>
</html>