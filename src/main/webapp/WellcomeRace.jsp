<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Race successfully created</title>
</head>
<body>
	<h2>Created Race:</h2>
	<span>Race:</span><b><%=request.getParameter("specie")%></b>
	<br>
	<br>
	<a href="ListRaces">Show the full list of races</a>
</body>
</html>  