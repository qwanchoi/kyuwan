<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeContent</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>공지사항</h1>
		</div>
		
		<br />
		<div>
			<table id="tb" border="1">
				<tr>
					<th width="70">작성자</th>
					<td width="870">${content.noticeName }
				</tr>
				<tr>
					<th>제 목</th>
					<td>${content.noticeTitle }</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>${content.noticeDate }</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${content.noticeHit }</td>
				</tr>
				<tr>
					<th height="400">작성글</th>
					<td>${content.noticeContents }</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
					<%-- <c:if test="${not empty content.noticeAttach}">
						<a href="downLoad.do?saveName=${content.noticeDir }" >
							${content.noticeAttach }
						</a>
					</c:if>
					<c:if test="${empty content.noticeAttach }">
						첨부파일이 없습니다.
					</c:if>--%>
					<c:choose>
						<c:when test="${not empty content.noticeAttach}">
							<a href="downLoad.do?saveName=${content.noticeDir }&fileName=${content.noticeAttach}" >
								${content.noticeAttach }
							</a>
						</c:when>
						<c:otherwise>
							첨부파일이 없습니다.
						</c:otherwise>
					</c:choose>
					</td>
				</tr>
			</table>
		</div>
		<br />
		<div>
			<button type="button" onclick="location.href='noticeModifyForm.do?noticeId=${content.noticeId}'">
				수 정</button>
			<button type="button" onclick="if(confirm('삭제 하시겠 습니까?'))location.href='noticeDelete.do?noticeId=${content.noticeId}'">
				삭 제</button>
			<button type="button" onclick="location.href='noticeList.do'">
				목록으로</button>
		</div>
		
	</div>
</body>
</html>