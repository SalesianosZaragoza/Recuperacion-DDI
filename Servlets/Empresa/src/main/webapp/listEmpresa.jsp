<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista empresas y alumnos</title>
</head>
<body>
<form action="cargarListado" method="post">
	<input type="submit" value="ver listado">
</form>


<%
List<Empresa> empresa = (List<Empresa>)request.getAttribute("listAllEmpresa");
 pageContext.setAttribute("empresa", empresa);

%>
<br/>
<br/>
<br/>
<!-- Esta hecho asi porque el alumno debera ir a alguna empresa cuando trabaje aunque no vaya a la FCT -->

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
		<c:forEach var="empresa1" items="${listAllEmpresa}">
			<tr>
				<td><c:out value="${empresa1.id}"/> </td>
				<td><c:out value="${empresa1.nombre}"/> </td>
				<td><a href="/confirmDeleteEmpresa?id=${empresa1.id}">DELETE</a> </td>
				<td><a href="/recoveryAddIdEmpresa?id=${empresa1.id}">Añadir alumno</a> </td>
	    		<td>
	    			<c:forEach var="alumno" items="${empresa1.alumnos}">
	    				<c:out value="${alumno.nombre } "/>
	    				<c:out value="${alumno.edad } "/>
	    				<c:out value="${alumno.asisteFCT  } "/>
	    				<c:out value=""><a href="/editAlumno?id=${alumno.id}">EDIT</a></c:out>
	    			</c:forEach>
	    		</td>
	    	</tr>
		</c:forEach>		
	</tbody>
</table>

</body>
</html>