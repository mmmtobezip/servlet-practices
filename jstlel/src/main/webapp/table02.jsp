<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"

pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
	<!-- row를 param으로 안주면 기본 3으로 셋팅  -->
	<c:set var="row" value="${param.r }" />
	<c:if test="${empty row }" >
		<c:set var="row" value="3" />
	</c:if>
	
	<!-- Page Context에 row, col로 저장하는 것. 단순 로직 -->
	<c:set var="col" value="${param.c }" />
	<c:if test="${empty col }" >
		<c:set var="col" value="3" />
	</c:if>
	
	<table border="1" cellspacing="0">
		<!-- 리터럴이면 그냥${0 } = "0"으로 값 줘도됨. -->
		<c:forEach begin="${0 }" end="${row - 1 }" step="1" var="i">  
			<tr>
				<td>cell(${i }, {)</td>
				<td>cell(${i }, 1)</td>
				<td>cell(${i }, 2)</td>		
		</c:forEach>
	</table>

</html>