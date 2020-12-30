<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="delete" method="post">
	<%-- <input type="hidden" name="num" value="${dto.num }"> --%>
	<input type="hidden" name="num" value="${num}">
	password : <input type="password" name="pass" required="required"><br>
	<button type="submit">delete</button><br><br>
	<button type="button" onclick="history.back();">cancel</button> 
</form>
</body>
</html>