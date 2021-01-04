<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="es.salesianos.model.Company" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Borrar Empresa</title>
</head>
<body>
	<div>
		<div>			
		  	<a>Borrar Empresa</a>				
			<a href='/listCompanies'  role="button">Volver</a>					
			
		</div>
		<div>
			<%
				Company company = (Company)request.getAttribute("company");
			%>
			<p>¿Desea borrar tambien sus alumnos?</p>
			<form action="deleteConfirmCompany" method="post">
				<div>
					<label for="id">id</label>
					<input id="id" type="text" name="id" value="<%=company.getId()%>" >
				</div>
				<div>
					<label for="deleteStudents">Borrar Alumnos:</label>
					<select id="deleteStudents" name="deleteStudents">
						<option value="false">No</option>
						<option value="true">Si</option>
					</select>
				</div>
				<button type="submit" >Borrar Alumnos</button>
			</form>
		</div>
	</div>
	</body>
</html>