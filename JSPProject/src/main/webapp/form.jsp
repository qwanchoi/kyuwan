<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form.jsp</title>
</head>
<body>
	<form name="frm" action="StudentGetServlet" method="GET">
		<input type="hidden" name="cmd" value="search">
		ID: <input type="number" name="user_id" value="100"><br>
		Name: <input type="text" name="user_name" value="홍길동"><br>
		Eng: <input type="number" name="eng_score" value="100"><br>
		Kor: <input type="number" name="kor_score" value="100"><br>
		<input type="submit" value="조회">
		<input id="addBtn" type="button" value="입력">
		<input id="modBtn" type="button" value="수정">
		<input id="delBtn" type="button" value="삭제">
	</form>
	<hr>
	<a href="./studentList.jsp">학생목록</a>
	
	<script>
	let modBtn = document.getElementById('modBtn');
	modBtn.addEventListener('click', function() {
		let frm = document.forms.frm;
		
		frm.action = "StudentGetServlet";
		frm.method = "POST";
		frm.cmd.value = "modify";
		
		frm.submit();
	});
	
	let delBtn = document.getElementById('delBtn');
	delBtn.addEventListener('click', function() {
		let frm = document.forms.frm;
		
		frm.action = "StudentGetServlet";
		frm.method = "POST";
		frm.cmd.value = "delete";
		
		frm.submit();
	});
	
	let btn = document.querySelector('#addBtn');
	btn.addEventListener('click', function() {
		let frm = document.forms.frm;
		
		frm.action = "StudentGetServlet";
		frm.method = "POST";
		frm.cmd.value = "add";
		
		frm.submit(); // form의 submit
	});
	</script>
</body>
</html>