
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar nuevo alumno</title>
</head>

<body>
	<form:form action="studentInsert" method="POST" modelAttribute="student">
				Nombre: <form:input type="text" path="name" />
				<br/>
				Edad: <form:input type="text" path="age" />
				<br/>
				AsisteFct <form:input type="text" path="asisteFCT" />	
				<br/>
				Id.empresa <form:input type="text" path="company" />			
				<button type="submit">Insertar</button>
	</form:form>
</body>
</html>