<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax.jsp</title>
</head>
<body>
	<script>
		// Asynchronous Javascript And XML.
		let url = "StudentGetServlet";
		fetch(url)
			.then(result => { // pending 상태
				console.log(result);
				return result.json(); // {"id":23, "name":"hong"}
			})
			.then(result => { // json으로 변환된 데이터
				console.log(result);
			})
			.catch(error => {
				console.log(error);
			});
		
	</script>
</body>
</html>