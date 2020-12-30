<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<c:set var="root" value="<%=request.getContextPath()%>" />

<body>
<h1>첫번쨰 레이아웃.</h1>
${root }<br>
<img src="${root}/image/c1.png">
<img src="${root}/image/c2.png">

<br><br>

<img src="${root}/image/c5.png">
<img src="${root}/image/c6.png">

</body>
</html>