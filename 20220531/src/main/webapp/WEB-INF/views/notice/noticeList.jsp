<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jquery-3.6.0.min.js"></script>
</head>
<style>
	table tr:hover {
		cursor : pointer;
		background: gray;
	}
</style>
<body>
	<div align="center">
		<div>
			<h1>공지사항 목록</h1>
		</div>
		<div>
			<form id="frm" action="javascript:searchListJQ()">
				<select id="state" name="state" form="frm">
					<option value="1">전체</option>
					<option value="2">작성자</option>
					<option value="3">제 목</option>
					<option value="4">내 용</option>
				</select>&nbsp; <input type="text" id="key" name="key">&nbsp;
				<input type="submit" value="검 색">
			</form>
		</div>
		<br />
		<div>
			<table id="tb" border="1">
				<thead>
					<tr>
						<th width="70">순번</th>
						<th width="150">작성자</th>
						<th width="300">제 목</th>
						<th width="150">작성일</th>
						<th width="70">조회수</th>
						<th width="70">첨부파일</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${notices ne null}">
						<c:forEach items="${notices }" var="n">
							<tr>
								<td>${n.noticeId }</td>
								<td>${n.noticeName }</td>
								<td>${n.noticeTitle }</td>
								<td>${n.noticeDate }</td>
								<td>${n.noticeHit }</td>
								<td>${n.noticeAttach }</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${notices eq null }">
						<tr>
							<td colspan="6" align="center">게시글이 존재하지 않습니다.</td>
						</tr>
					</c:if>
				</tbody>
			</table>
			<form id="frm2" action="" method="post">
				<input type="hidden" id="noticeId" name="noticeId">
			</form>
		</div>
		<br />
		<div>
			<button type="button" onclick="location.href='noticeInsertForm.do'">글
				등록</button>
		</div>
		
	</div>
	<!-- 그룹이벤트 생성(상세조회) -->
<script>
	tbodyEventInit();
	function tbodyEventInit(){
		let list = document.querySelector('tbody');
		list.addEventListener('click', function(ev) {
			if(ev.target.tagName === 'TD') {
				//location.href = 'getContent.do?noticeId='+ev.target.parentNode.children[0].textContent;
				frm2.noticeId.value = ev.target.parentNode.children[0].textContent;
				frm2.action="getContent.do";
				frm2.submit();
			}
		});
	}
</script>
<script type="text/javascript">
	function searchListJQ(){
		let state = $("#state").val(); // document.getelementById("state").value();
		let key = $("#key").val();
		
		$.ajax({
			url: "ajaxSearchList.do", // url
			type: "POST",
			data: {"state":state, "key":key},
			dataType: "json", // 돌려받을 결과의 데이터 타입 html, text, xml, json, jsonp
			success: function(data) { //성공했을 때 실행할 함수 결과는 data에 담김
				// 수행할 영역
				htmlConvertJQ(data);
			},
			error: function() {
				alert('의도치 않는 오류가 발생 했습니다.');
			}
		});
	}
	
	function htmlConvertJQ(data) {
		$("tbody").children().remove(); // tbody
		let tbody = $("tbody");
		$.each(data, function(index, n) {
			var row = $("<tr />").append(
					$("<td />").text(n.noticeId),
					$("<td />").text(n.noticeName),
					$("<td />").text(n.noticeTitle),
					$("<td />").text(n.noticeDate),
					$("<td />").text(n.noticeHit),
					$("<td />").text(n.noticeAttach),
				);
			tbody.append(row); //행을 추가
		});
		$("#tb").append(tbody); //tbody를 추가
	}
	
	function searchList() {
		fetch('ajaxSearchList.do', {
			method: 'POST',
			body: new FormData(document.getElementById('frm'))
		})
		.then(response => response.json())
		.then(result => {
			drawTbTable(result);
		});
	}
	
	function drawTbTable(dataList) {
		let tbody = document.querySelector('#tb tbody');
		let theadArr = ['noticeId', 'noticeName', 
			'noticeTitle', 'noticeDate',  'noticeHit', 'noticeAttach'];
		//while(tbody.children[0]){
//			tbody.children[0].remove();
		//}
		tbody.innerHTML = '';
		for(let data of dataList) {
			let mtr = document.createElement('tr');
			theadArr.forEach( v => {
				let mtd = document.createElement('td');
				mtd.innerText = data[v];
				mtr.appendChild(mtd);
			});
			
			tbody.appendChild(mtr);
		}
	}
</script>
</body>
</html>