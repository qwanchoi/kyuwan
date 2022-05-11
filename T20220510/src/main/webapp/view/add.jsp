<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>

    <h3>도서등록</h3>
    <form action="../addBook.do" method="post">
        제목: <input type="text" name="title"><br>
        저자: <input type="text" name="author"><br>
        출판사: <input type="text" name="press"><br>
        가격: <input type="number" name="price"><br>
        <input type="submit" value="등록">
    </form>
    
    <a href="${pageContext.servletContext.contextPath }/index.jsp">첫페이지</a>

</body>

</html>