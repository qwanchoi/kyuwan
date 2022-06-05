<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<div>
	<c:forEach items="${list }" var="notice">
		${notice.id } : ${notice.title } : ${notice.name }
	</c:forEach>
</div>