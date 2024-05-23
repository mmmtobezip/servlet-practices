<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String no = request.getParameter("no");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/gb" method="post"> /gb?a=delete&no=8&password=123
		<input type='hidden' name='a' value="delete"> 
		<input type='hidden' name="no" value="<%=no %>">
		<table>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td> 
				<td><input type="submit" value="확인"></td>
			</tr>
		</table>
		</form>
		<br><br>
		<p>
			<a href="<%=request.getContextPath() %>/gb"></a>
		</p>
</body>
</html>