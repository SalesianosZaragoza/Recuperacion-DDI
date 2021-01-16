
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar nuevo Libro</title>
</head>

<%
 request.getAttribute("warehouse");
%>

<body>
	<form action="/addBookNew" method="post">
		<input type="text" name="idNew" value="<c:out value="${warehouse.id}"/>" style="display:none" >
		<span>Isbn:</span><input type="text" name="isbn">
		<span>Fecha edicion:</span><input type="text" name="dateEdition" placeholder="Example: 2001-12-29">
		<input type="submit">
	</form>
</body>
</html>