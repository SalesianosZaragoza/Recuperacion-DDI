<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista companys y students</title>
</head>
<body>
<form action="loadList" method="post">
	<input type="submit" value="ver listado">
</form>


<%
List<Company> company = (List<Company>)request.getAttribute("listAllCompany");
 pageContext.setAttribute("company", company);

%>
<br/>
<div>
		<a href="addCompany.jsp">Quiero añadir una empresa</a>
</div>
<br/>
<br/>
<!-- Esta hecho asi porque el student debera ir a alguna company cuando trabaje aunque no vaya a la FCT -->

<table border="1">
	<thead>
		<tr>
			<td>Cod.</td>
			<td>Name</td>
			<td>Borrar</td>
			<td>Añadir Alumno</td>
			<td>Alumnos</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="company1" items="${list}">
			<tr>
				<td><c:out value="${company1.id}"/> </td>
				<td><c:out value="${company1.name}"/> </td>
				<td><a href="confirmDeleteCompany?id=${company1.id}">DELETE</a> </td>
				<td><a href="/insertStudent">Añadir alumno</a> </td>
	    		<td>
	    			<c:forEach var="student" items="${company1.students}">
	    				<div>
		    				<c:out value="${student.name } "/>
		    				<c:out value="${student.age } "/>
		    				<c:out value="${student.asisteFCT  } "/>
		    				<a href="/studentEdit?id=${student.id}">EDIT</a>
	    				</div>
	    			</c:forEach>
	    		</td>
	    	</tr>
		</c:forEach>		
	</tbody>
</table>

</body>
</html>