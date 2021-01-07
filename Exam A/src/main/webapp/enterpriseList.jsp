<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.io.*,java.util.*,models.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="enterpriseList" method="post">
		<input type="submit" value="ver listado">
	</form>

	<%
		List<Enterprise> enterprises = (List<Enterprise>) request.getAttribute("listAllEnterprises");
		out.println(enterprises);
		pageContext.setAttribute("enterprises", enterprises);
	%>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />

	<table border="1">
		<thead>
			<tr>
				<td>Nombre</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="enterprise" items="${listAllEnterprises}">
				<tr>
					<td><c:out value="${enterprise.getName()}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>