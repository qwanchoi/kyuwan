<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberDelete.jsp</title>
</head>
<body>
${error }
<h3>회원삭제검색</h3>
	<form action="${pageContext.servletContext.contextPath }/memberSearch.do" method="GET">
		조회 아이디: <input type="text" name="id"><br>
		<input type="hidden" name="job" value="delete">
		<input type="submit" value="Search">
	</form> <br>
	<c:choose>
		<c:when test="${!empty result }"><h3>${result }</h3></c:when>
		<c:otherwise>
			<form action="${pageContext.servletContext.contextPath }/memberDelete.do" method="POST">
				삭제ID: <input type="text" name="id" readonly value="${member.id }">
				<input type="submit" value="삭제">
			</form>
		</c:otherwise>
	</c:choose>
	
	
	<jsp:include page="/memberResult/home.jsp"></jsp:include>
</body>
</html>