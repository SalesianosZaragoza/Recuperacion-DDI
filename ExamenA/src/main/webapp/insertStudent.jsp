<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*,com.mycompany.model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert student</title>
</head>
<body>
<form action="/student" method="post">
		<span>Name:</span> <input type="text" name="name"> <br />
		<span>Age:</span> <input type="text" name="age"> <br />
		<span>FCT asists:</span> <input type="checkbox" name="Asists FCT"> <br />
		<span>Company:</span> <input type="text" name="company"> <br />
		<input type="submit" value="Insert">
	</form>
	<a href="">List</a>
</body>
</body>
</html>