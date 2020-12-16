<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,es.salesianos.model.Almacen" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insertar Libro</title>
</head>
<body>
	<div>
		<div>
			
		</div>
		<div>
			<p>Rellena el formulario a continuación.</p>
			<form action="insertarLibro" method="post">
				<div>
					<span for="isbn">Isbn</span>
					<input id="isbn" type="text" name="isbn">
				</div>
				<div>
					<span for="fechaEdicion">Fecha Edición</span>
					<input id="fechaEdicion" type="date" name="fechaEdicion" onchange="onCambiarFecha(this)">
				</div>
				<div>
					<span>Almacen:</span>
					<select id="almacen_helper">
						<option>- Selecciona una fecha primero -</option>
					</select>
					<% List<Almacen> almacenes_old = (List<Almacen>)request.getAttribute("almacenes_old"); %>
					<select id="almacenes_old" name="almacenes_old" style="display: none">
						<c:forEach var="almacen" items="${almacenes_old}">
							<option value="${almacen.getId()}">
								<c:out value="${almacen.getName()}"/>
					    	</option>
						</c:forEach>
					</select>
					<% List<Almacen> almacenes_new = (List<Almacen>)request.getAttribute("almacenes_new"); %>
					<select id="almacenes_new" name="almacenes_new" style="display: none">
						<c:forEach var="almacen" items="${almacenes_new}">
							<option value="${almacen.getId()}">
								<c:out value="${almacen.getName()}"/>
					    	</option>
						</c:forEach>
					</select>
				</div>
	 			<button type="submit" >Insertar</button>
			</form>
		</div>
	</div>
	
</body>
</html>