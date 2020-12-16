<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.List,es.salesianos.model.Libro" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Listado de Libros</title>
</head>
<body>
	<div>
		<div>
			
		</div>
		<div>
			<table>
			  <thead>
			    <tr>
			      <th>id</th>
			      <th>isbn</th>
			      <th>fechaEdicion</th>
			      <th>almacen</th>
			      <th></th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>
			  	<% List<Libro> libros = (List<Libro>)request.getAttribute("libros"); %>
				<c:forEach var="libro" items="${libros}">
					<tr>
						<td><c:out value="${libro.getId()}"/></td>
						<td><c:out value="${libro.getIsbn()}"/></td>
						<td><c:out value="${libro.getShortDate()}"/></td>
						<td><c:out value="${libro.getAlmacen().getName()}"/></td>
						<td><a href='/borrarLibro?id=${libro.getId()}'  role="button" >Borrar</a></td>
			    	</tr>
				</c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
	</body>
</html>