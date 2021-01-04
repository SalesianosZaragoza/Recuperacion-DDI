<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,es.salesianos.model.Company" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Insertar Alumno</title>
</head>
<body>
	<div>
		<div>			
			  	<a>Insertar un nuevo Alumno</a>		
		</div>
		<div>
			<p>Rellena el formulario a continuación.</p>
			<form action="insertStudent" method="post">
				<div>
					<label for="name">Nombre:</label>
					<input id="name" type="text" name="name">
				</div>
				<div>
					<label for="age">Edad:</label>
					<input id="age" type="text" name="age">
				</div>
				<div>
					<label for="asistFCT">Asiste FCT:</label>
					<select id="asistCT" name="asistFCT">
						<option value="false">No</option>
						<option value="true">Si</option>
					</select>
				</div>
				<div>
					<label>Empresa:</label>
					<%
						List<Company> companies = (List<Company>)request.getAttribute("companies");
					%>
					<select id="company" name="company">
						<c:forEach var="company" items="${companies}">
							<option value="${company.getId()}">
								<c:out value="${company.getName()}"/>
					    	</option>
						</c:forEach>
					</select>
				</div>
	 			<button type="submit">Insertar</button>
			</form>
		</div>
	</div>
	</body>
</html>