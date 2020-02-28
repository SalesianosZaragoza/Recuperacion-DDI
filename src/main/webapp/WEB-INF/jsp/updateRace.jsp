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
		<title>Update race</title>
	</head>
	<body>
		<form action="/updateRace?id=${race.id}" method="post">
		        <span>ID:</span> <input type="text" value="${race.id}" disabled="disabled" name="id"> <br />
		        <span>Specie:</span> <input type="text" value="${race.specie}" name="specie"> <br />
		        <input type="submit">
		 </form>
		 						<span>Index</span>
		<form action="index">
			<input type="submit" value="index">
		</form>
	</body>
</html>