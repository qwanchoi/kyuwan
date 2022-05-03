<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberView/memberInsert.jsp</title>
</head>
<body>
	<h3>회원가입화면</h3>
	<form action="../memberInsert.do" method="POST">
		아이디: <input type="text" name="id"> <br>
		비밀번호: <input type="password" name="passwd"> <br>
		이름: <input type="text" name="name"> <br>
		메일: <input type="email" name="email"> <br>
		<input type="submit" value="추가">
	</form>
</body>
</html>