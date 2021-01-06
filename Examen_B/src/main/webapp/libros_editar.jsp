<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="es.salesianos.model.Book,java.util.List,es.salesianos.model.Warehouse" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Editar Libro</title>
</head>
<body>
	<div class="container-fluid">
		<div class="m-4">
			<nav class="navbar navbar-light bg-light justify-content-between">
			  	<a class="navbar-brand">Editar Libro</a>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item p-1">
						<a href='/listadoLibros' class="btn btn-primary" role="button" aria-disabled="true">Volver</a>
					</li>
				</ul>
			</nav>
		</div>
		<div class="p-4">
			<p>Modifica los campos que necesites a continuación.</p>
			<%
			Book book = (Book)request.getAttribute("libro");
			%>
			<form action="editarLibro" method="post">
				<div class="form-group">
					<label for="id">id</label>
					<input id="id" type="text" name="id" value="<%=book.getId()%>" readonly>
				</div>
				<div class="form-group">
					<label for="isbn">Isbn</label>
					<input id="isbn" type="text" name="isbn" value="<%=book.getIsbn()%>">
				</div>
				<div class="form-group">
					<label for="editionDate">Fecha Edición</label>
					<input id="editionDate" type="date" name="editionDate" value="<%=book.getShortDate()%>" onchange="onDateChange(this)">
				</div>
				<div class="form-group">
					<label>Almacen:</label>
					<%
					List<Warehouse> almacenes_old = (List<Warehouse>)request.getAttribute("almacenes_old");
					%>
					<select id="almacenes_old" name="almacenes_old" autocomplete="off" ${book.getAlmacen_new() == -1 ? "style='display: inline-block'" : "style='display: none'"}>
						<c:forEach var="warehouse" items="${almacenes_old}">
							<option value="${warehouse.getId()}" ${warehouse.getId().equals(book.getWarehouse().getId()) ? "selected='selected'" : ""}>
								<c:out value="${warehouse.getName()}"/>
					    	</option>
						</c:forEach>
					</select>
					<%
					List<Warehouse> almacenes_new = (List<Warehouse>)request.getAttribute("almacenes_new");
					%>
					<select id="almacenes_new" name="almacenes_new" autocomplete="off" ${book.getAlmacen_old() == -1 ? "style='display: inline-block'" : "style='display: none'"}>
						<c:forEach var="warehouse" items="${almacenes_new}">
							<option value="${warehouse.getId()}" ${warehouse.getId().equals(book.getAlmacen().getId()) ? "selected='selected'" : ""}>
								<c:out value="${warehouse.getName()}"/>
					    	</option>
						</c:forEach>
					</select>
				</div>
	 			<button type="submit" class="btn btn-primary">Actualizar</button>
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script type="text/javascript">
		var almacenes_old;
		var almacenes_new;
		
		window.onload = function() {
			almacenes_old = document.getElementById('almacenes_old');
			almacenes_new = document.getElementById('almacenes_new');
		}
	
		function onDateChange(input) {
			var d = new Date(input.value);
			var year = d.getFullYear();
			if (isNaN(year)) {
				return;
			}
			
			if (year < 2000) {
				almacenes_new.style.display = "none";
				almacenes_old.style.display = "inline-block";
			} else {
				almacenes_old.style.display = "none";
				almacenes_new.style.display = "inline-block";
			}
		}
	</script>
</body>
</html>