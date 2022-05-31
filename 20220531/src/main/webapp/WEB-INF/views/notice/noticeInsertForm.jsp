<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div><h1>게시글 등록</h1></div>
		<div>
			<form id="frm" action="noticeInsert.do" method="post" enctype="multipart/form-data">
				<label for="noticeName">작성자</label>
				<input type="text" id="noticeName" name="noticeName"> 
				<label for="noticeDate">작성일자</label>
				<input type="date" id="noticeDate" name="noticeDate" ><p />
				<label for="noticeTitle">제목</label>
				<input type="text" id="noticeTitle" name="noticeTitle" required="required"> <p />
				<label for="noticeContents">내용</label>
				<textarea rows="10" cols="40" id="noticeContents" name="noticeContents"></textarea> <p />
				<label for="noticeAttach">첨부파일</label>
				<input type="file" id="file" name="file"> <p />
				<input type="submit" value="저장"> &nbsp;&nbsp;
				<input type="reset" value="취소"> &nbsp;&nbsp;
				<button onclick="location.href='noticeList.do'">목록</button>
			</form>
		</div>
	</div>
</body>
</html>