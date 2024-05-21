<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/helloweb/join.jsp" method="get"> <!-- submit한 값이 보내지는 곳 -->
		<label>이메일:</label>
		<input type="text" name="email" value="">
		<br><br>
		
		<label>비밀번호:</label>
		<input type="password" name="password" value="">
		<br><br>
		
		<label>생년:</label>
		<select name="birthYear">
			<option value="2000">2000년</option>  <!-- 2000년은 넘어가는 값이 아님 -->
			<option value="1999">1990년</option>
			<option value="1998">1998년</option>
		</select>
		<br><br>
		
		<label>성별:</label>
		여자 <input type="radio" name="gender" value="female">
		남자 <input type="radio" name="gender" value="male">
		<br><br>
		
		<label>자기소개:</label>
		<br>
		<textarea name="profile"></textarea>
		<br><br>
		
		<label>취미:</label>
		<br>
		코딩: <input type="checkbox" name="hobby" value="coding"> <!-- name의 카테고리는 동일해야함 -->
		술먹기: <input type="checkbox" name="hobby" value="drinking">
		요리: <input type="checkbox" name="hobby" value="cooking">
		수영: <input type="checkbox" name="hobby" value="swimming">
		<br><br>
		
		<input type="submit" value="회원가입">
	</form>
</body>
</html>