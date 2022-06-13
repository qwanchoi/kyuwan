<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" 
	prefix="sec" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/sample/admin page</h1>
	
	<p>principal : <sec:authentication property="principal" /></p>
	<p>studentVO : <sec:authentication property="principal.student"/></p>
	<p>사용자이름 : <sec:authentication property="principal.student.name"/></p>
	<p>사용자이이디 : <sec:authentication property="principal.username"/></p>
	<p>사용자 권한 : <sec:authentication property="principal.student.authList[0].rolename"/></p>
	
	<br/><a href="${pageContext.request.contextPath}/customLogout">Logout</a>
</body>
</html>