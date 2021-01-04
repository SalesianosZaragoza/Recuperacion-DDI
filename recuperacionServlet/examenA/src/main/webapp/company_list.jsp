<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,es.salesianos.model.Company" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Listado de Empresas</title>
</head>
<body>
	<div>		
	  	<a>Listado de Empresas</a>				
		<a href='/company_insert.jsp' role="button" >Insertar</a>
		<a href='/listStudents' role="button" >Alumnos</a>			
	</div>
		<div>
			<table>
			  <thead>
			    <tr>
			      <th scope="col">id</th>
			      <th scope="col">nombre</th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody>
			  	<%
			  		List<Company> companies = (List<Company>)request.getAttribute("companies");
			  	%>
				<c:forEach var="company" items="${companies}">
					<tr>
						<td><c:out value="${company.getId()}"/></td>
						<td><c:out value="${company.getName()}"/></td>
						<td><a href='/deleteCompany?id=${company.getId()}' role="button">Borrar</a></td>
			    	</tr>
				</c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
	</body>
</html>