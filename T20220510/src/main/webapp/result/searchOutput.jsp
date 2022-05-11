<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${empty book.bookTitle }"><h3>조회 결과가 없습니다.</h3></c:when>
	<c:otherwise>
		<h3>조회결과</h3>
		<h2>${book.bookTitle }</h2>
		<ul>
			<li>코드: ${book.bookCode }</li>
			<li>저자: ${book.bookAuthor }</li>
			<li>출판: ${book.bookPress }</li>
			<li>가격: ${book.bookPrice }</li>
		</ul>
	    <a href="${pageContext.servletContext.contextPath }/index.jsp">첫페이지</a>
	</c:otherwise>
</c:choose>
</body>
</html>