<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberSearchOutput.jsp</title>
</head>
<body>
	<h3>검색결과</h3>
	<c:if test="${!empty result }"><h4>${result }</h4></c:if>
	<c:if test="${!empty member }">
		<h4>${member.id } / ${member.name } / ${member.email } / ${member.passwd }</h4>
	</c:if>
	<jsp:include page="home.jsp"></jsp:include>
</body>
</html>