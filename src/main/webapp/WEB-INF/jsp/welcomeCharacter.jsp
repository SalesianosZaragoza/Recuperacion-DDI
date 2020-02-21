<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cosmo/bootstrap.min.css"
	rel="stylesheet">

<title>Character created!!</title>
</head>
<body>
		<span >Character created</span>
	<label>Name:</label>
	<b><%=request.getParameter("name")%></b>
	<br />
	<label>Ring Bearer:</label>
	<b><%=request.getParameter("ringBearer")%></b>
	<br />
	<label>Race code:</label>
	<b><%=request.getParameter("codRace")%></b>
	<br />
	<form action="listcharacters" method="post">
		<input type="submit"
			value="Character List">
	</form>
</body>
</html>