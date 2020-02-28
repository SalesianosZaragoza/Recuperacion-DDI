<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
body {
    background-image: url("img/background.jpg");
}
</style>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Race insert</title>
	</head>
	<body>
		<h2>Done!</h2>
		<span>Race:</span><b><%=request.getParameter("specie")%></b>
		<br>
		<form action="listraces" method="post">
			<input type="submit" value="Race List">
		</form>
								<span>Index</span>
		<form action="index">
			<input type="submit" value="index">
		</form>
	</body>
</html>