<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome page</title>
</head>
<body>
Bienvenido
<b><%= request.getParameter("name_student") %></b>
<b><%= request.getParameter("age") %></b>
<b><%= request.getParameter("FCTasists") %></b>
<b><%= request.getParameter("company") %></b>
</body>
</html>