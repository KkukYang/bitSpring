<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>print multi images</h1>
	${list}
	<br>
	<br>
	<br>
	<c:forEach var="my" items="${list}">
		${my}<br>
		<img src="${my}">
		<br><br>
	</c:forEach>

</body>
</html>