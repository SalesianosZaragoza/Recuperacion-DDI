<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,es.salesianos.model.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Listado de Alumnos</title>
</head>
<body>
	<div>
		<div>
			  	<a>Listado de Alumnos</a>				
				<a href='/insertStudent'  role="button" >Insertar</a>					
		</div>
		<div>
			<table>
			  <thead>
			    <tr>
			      <th scope="col">id</th>
			      <th scope="col">nombre</th>
			      <th scope="col">edad</th>
			      <th scope="col">asisteFCT</th>
			      <th scope="col">empresa</th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody>
			  	<%
			  		List<Student> students = (List<Student>)request.getAttribute("students");
			  	%>
				<c:forEach var="student" items="${students}">
					<tr>
						<td><c:out value="${student.getId()}"/></td>
						<td><c:out value="${student.getName()}"/></td>
						<td><c:out value="${student.getAge()}"/></td>
						<td><c:out value="${student.isAsistFCT() ? 'Si' : 'No'}"/></td>
						<td><c:out value="${student.getObjCompany().getName()}"/></td>
						<td><a href='/editStudent?id=${student.getId()}'  role="button" >Editar</a></td>
			    	</tr>
				</c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
	</body>
</html>