<%@page import= "jstlel.UserVo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//page context에 담기 위해 java code 사용 - jsp에서 제공하는 태그가 존재
	UserVo vo4 = new UserVo();
	vo4.setNo(4L);
	vo4.setName("둘리4");
	pageContext.setAttribute("vo", vo4);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Scope(객체의 존속 범위)</h4>
	${vo.no } <br> <!--  page context에 있는 vo부터 가져옴. -->
	${vo.name } <br>
	
	== 1. Reqeust Scope =============<br>
	${rquestScope.vo.no } <br>
	${requestScope.vo.name } <br>
	
	== 2. Session Scope =============<br>
	${sessionScope.vo.no } <br>
	${sessionScope.vo.name } <br>

	== 3. Application Scope =============<br>
	${applicationScope.vo.no } <br>
	${applicationScope.vo.name } <br>
</body>
</html>