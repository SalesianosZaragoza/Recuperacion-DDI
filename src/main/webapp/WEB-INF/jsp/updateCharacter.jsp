<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cosmo/bootstrap.min.css"
	rel="stylesheet">

<title>Update character</title>
</head>
<body>
		<span>Update character</span>
	<br />
	<form:form action="updateCharacter?id=${character.id}" method="post" modelAttribute="character">
		<label>ID: </label> 
		<input type="text" name="id" value="${character.id}" disabled="disabled"> 
		<br /> 
		<label>Name:</label> 
		<input type="text" name="name" value="${character.name}"> 
		<br />
		<label>Ring Bearer:</label>
		<select name="carrier">
			<option value="YES">YES</option>
			<option value="NO">NO</option>
		</select>
		<br /> 
		<label>Race code: </label> 
		<input type="text" name="codRace"
			value="${character.codRace}"> 
			<br /> 
			<input value="Update" type="submit">
	</form:form>
</body>
</html>