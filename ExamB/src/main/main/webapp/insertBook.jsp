<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert books</title>
</head>
<body>
<div>
			<p>Complete the form</p>
			<form action="insertBook" method="post">
				<div>
					<span for="isbn">ISBN</span>
					<input id="isbn" type="text" name="isbn">
				</div>
				<div>
					<span for="dateEdicion">Date Edition</span>
					<input id="dateEdicion" type="date" name="dateEdition" onchange="onChangeDate(this)">
				</div>
				<div>
					<span>Warehouse:</span>
					<select id="warehouse_helper">
						<option>- Select one date first -</option>
					</select>
					<% List<Warehouse> warehouses_old = (List<Warehouse>)request.getAttribute("warehouses_old"); %>
					<select id="warehouses_old" name="warehouses_old" style="display: none">
						<c:forEach var="warehouse" items="${warehouses_old}">
							<option value="${warehouse.getId()}">
								<c:out value="${almacen.getName()}"/>
					    	</option>
						</c:forEach>
					</select>
					<% List<Warehouse> warehouses_new = (List<Warehouse>)request.getAttribute("warehouses_new"); %>
					<select id="warehouses_new" name="warehouses_new" style="display: none">
						<c:forEach var="warehouse" items="${warehouses_new}">
							<option value="${warehouse.getId()}">
								<c:out value="${warehouse.getName()}"/>
					    	</option>
						</c:forEach>
					</select>
				</div>
	 			<button type="submit" >Insert</button>
			</form>
		</div>
</body>
</html>










