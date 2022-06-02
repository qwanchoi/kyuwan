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
			<form id="frm" action="noticeModify.do" method="post" enctype="multipart/form-data">
				<input type="hidden" id="noticeId" name="noticeId" value="${notice.noticeId }"/>
				<label for="noticeName">작성자</label>
				<input type="text" id="noticeName" name="noticeName" value="${notice.noticeName }" readonly="readonly"><p />
				<label for="noticeDate">작성일자</label>
				<input type="date" id="noticeDate" name="noticeDate" value="${notice.noticeDate}" readonly="readonly"><p />
				<label for="noticeTitle">제목</label>
				<input type="text" id="noticeTitle" name="noticeTitle" value="${notice.noticeTitle }" required="required"> <p />
				<label for="noticeContents">내용</label>
				<textarea rows="10" cols="40" id="noticeContents" name="noticeContents"
					>${notice.noticeContents }</textarea> <p />
				<label for="noticeAttach">첨부파일</label>
				<input type="file" id="file" name="file"> <p />
				<input type="submit" value="수정"> &nbsp;&nbsp;
				<input type="reset" value="취소">
			</form>
		</div>
	</div>
</body>
</html>