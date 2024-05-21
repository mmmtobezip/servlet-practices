<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/hellweb/join.jsp" method="post"> <!-- submit한 값이 보내지는 곳 -->
		<label>이메일:</label>
		<input type="text" name="email" value="">
		<br><br>
		
		<label>비밀번호:</label>
		<input type="password" name="password" value="">
		<br><br>
		
		<input type="submit" value="회원가입">
	</form>
</body>
</html>