<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="es.salesianos.model.Company,java.util.List,es.salesianos.model.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Editar Alumno</title>
</head>
<body>
	<div>
		<div>
		  	<a>Editar Alumno</a>				
			<a href='/listStudents'  role="button" >Volver</a>								
		</div>
		<div>
			<p>Modifica los campos que necesites a continuación.</p>
			<%
				Student student = (Student)request.getAttribute("student");
			%>
			<form action="editStudent" method="post">
				<div>
					<label for="id">id</label>
					<input id="id" type="text" name="id" value="<%=student.getId()%>" readonly>
				</div>
				<div>
					<label for="name">Nombre:</label>
					<input id="name" type="text" name="name" value="<%=student.getName()%>">
				</div>
				<div>
					<label for="age">Edad</label>
					<input id="age" type="text" name="age" value="<%=student.getAge()%>">
				</div>
				<div>
					<label for="asistFCT">Asiste FCT:</label>
					<select id="asistFCT" name="asistFCT" autocomplete="off">
						<option value="false" ${student.isAsistFCT() == false ? "selected='selected'" : ""}>No</option>
						<option value="true" ${student.isAsistFCT() ? "selected='selected'" : ""}>Si</option>
					</select>
				</div>
				<div>
					<label>Empresa:</label>
					<%
						List<Company> companies = (List<Company>)request.getAttribute("companies");
					%>
					<select id="company" name="company" autocomplete="off">
						<option value="null"></option>
						<c:forEach var="company" items="${companies}">
							<option value="${company.getId()}" ${company.getId().equals(student.getCompany()) ? "selected='selected'" : ""}>
								<c:out value="${company.getName()}"/>
					    	</option>
						</c:forEach>
					</select>
				</div>
	 			<button type="submit" >Actualizar</button>
			</form>
		</div>
	</div>
	</body>
</html>