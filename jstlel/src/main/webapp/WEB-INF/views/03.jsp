<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	pageContext.setAttribute("newline", "\n");
%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
	<h4>JSTL Test: forEach, set, fn:length</h4>
<!-- 
	<c:forEach items='${userList }' var='vo' varStatus="status">
		<h4>[${3-status.index}](${status.index}: ${status.count }) ${vo.no } : ${vo.name } </h4>
	</c:forEach>
 -->	
	<c:set var="count" value="${fn:length(userList) }" />
	<c:forEach items='${userList }' var='vo' varStatus="status">
		<h4>[${count-status.index}] (${status.index}: ${status.count }) ${vo.no } : ${vo.name } </h4>
	</c:forEach>
	
	<h4>JSTL Test: fn:replace</h4>	
	<p>
		${fn:replace(contents, newline, "<br>") }
	</p>
	
</html>