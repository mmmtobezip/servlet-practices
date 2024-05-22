<%@page import="guestbook.dao.GuestBookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	Long no = Long.parseLong(request.getParameter("no"));
	String password = request.getParameter("password");
	
	new GuestBookDao().deleteByNoAndPassword(no, password);
	
	response.sendRedirect("/guestbook1");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>