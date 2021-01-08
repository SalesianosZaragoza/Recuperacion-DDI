<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*,com.mycompany.model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of students</title>
</head>
<body>
<form method="post" action="/list">
    <input type="submit" value="View list of students">
</form>

<table>
<!-- TAGLIB -->
    <thead>
       <th>Name</th>
       <th>Age</th>
       <th>FCTasists</th>
	   <th>Company</th>
       <th>Delete</th>
       <th>Update</th>
    </thead>

	<c:forEach items="${listOfStudents}" var="student">
	    
	    
	    <tr>
	        <td>${student.name_student}</td>
	        <td>${student.age}</td>
	        <td>${student.FCTasists}</td>
			<td>${student.company}</td>
	        <td><a href="/delete?name=${student.name_student}&age=${student.age}&fctasists=${student.FCTasists}">Delete</a></td>
	        <td><a href="/update?id=${student.id}">Update</a></td>
	        
	    </tr>
	</c:forEach>
</table>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<table>
<%
//scriplet
 List<Student> students = (List<Student>)request.getAttribute("listOfStudents");
if(students!= null && !students.isEmpty()){
	for(Student student : students){
	    out.println("<tr>");
	    out.println("<td>");
	    out.println(student.getName_student());
	    out.println("</td>");
	    out.println("<td>");
        out.println(student.getAge());
        out.println("</td>");
	    out.println("<td>");
	    out.println(student.getFCTasists());
        out.println("</td>");
	    out.println("</tr>");
		out.println(student.getCompany());
        out.println("</td>");
	    out.println("</tr>");
		
	}
}

%>
</table>







</body>
</html>