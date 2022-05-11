<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>

	<h3>${error }</h3>

    <h3>도서수정조회</h3>
    <form id="form" action="" method="POST">
        <input type="text" name="bookCode"><br>
        <input type="hidden" name="job" value="modify">
        <input type="submit" value="조회">
    </form>
    
    <!-- 도서수정을 위한 화면 작성코드를 입력하세요. -->
		<div id="reuslt">
			<form action="../modifyBook.do" method="POST">
				코드: <input type="text" name="code" readonly><br>
        제목: <input type="text" name="title"><br>
        저자: <input type="text" name="author"><br>
        출판사: <input type="text" name="press"><br>
        가격: <input type="number" name="price"><br>
        <input type="submit" value="수정">
    </form>
		</div>
    <a href="${pageContext.servletContext.contextPath }/index.jsp">첫페이지</a>
<script src="${pageContext.servletContext.contextPath }/view/search.js"></script>
</body>

</html>