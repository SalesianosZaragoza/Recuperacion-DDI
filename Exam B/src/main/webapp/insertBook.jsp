<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*, model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/JavaScript">
	StorehouseAsignation(){
		var dat = new Date(editionDate.value)
		var year = date.getFullYear();
		
		if(year > 2000){
			newStore.style.display = "inherit";
		}
		if(year < 2000){
			oldStore.style.display = "inherit";
		}
	}
</script>
</head>
<body>
	<form action="insertBook" method="post">
		<span>Isbn:</span>
		<input type="text" name="isbn"> <br/>
		
		<span>Fecha de edicion</span>
		<input type="date" name="editionDate" id="editionDate" onchange="StorehouseAsignation()"/><br/>
		
		<select style="display:none" name="newStore">
			<c:forEach var="newS" items="${listAllNewStorehouse}">
				<option value="">${newS.name}
			</c:forEach>
		</select>
		
		<select  style="display:none" name="OldStore">
			<c:forEach var="oldS" items="${listAllOldStorehouse}">
				<option value="${oldS.name}">${old.name}
			</c:forEach>
		</select>
		
	</form>
</body>
</html>