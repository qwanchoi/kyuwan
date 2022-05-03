<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session2.jsp</title>
</head>
<body>
	<%
		String id = (String) session.getAttribute("id");
		String pw = (String) session.getAttribute("pass");
		
		out.print("<h3>아이디: " + id + "</h3>");
		out.print("<h3>비번: " + pw + "</h3>");
	%>
</body>
</html>