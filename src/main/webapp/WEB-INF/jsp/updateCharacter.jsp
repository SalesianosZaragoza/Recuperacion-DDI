<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
body {
    background-image: url("img/background.jpg");
}
</style>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Update</title>
	</head>
	<body>
		<form action="/updateCharacter?id=${character.id}" method="post">
		        <span>ID:</span> <input type="text" value="${character.id}" disabled="disabled" name="id"> <br />
		        <span>Name:</span> <input type="text" value="${character.name}" name="name"> <br />
		        <span>Ring bearer:</span> 
		        	<select name="holder">
						<option value=true>Yes</option>
						<option value=false>No</option>
					</select> 
				<br />
		        <span>Race code:</span> <input type="text" value="${character.codRace}" name="codRace"> <br />
				<br><br>
		        <input type="submit">
		    </form>
		    						<span>Index</span>
		<form action="index">
			<input type="submit" value="index">
		</form>
	</body>
</html>