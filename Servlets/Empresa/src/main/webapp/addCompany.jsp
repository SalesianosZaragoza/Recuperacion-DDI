<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar empresa</title>
</head>
<body>
	<form:form action="insertCompany" method="POST" modelAttribute="company">
		Nombre: <form:input type="text" path="name" />
		<button type="submit">Insertar</button>
	</form:form>
</body>
</html>