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

<h1>두번쨰 레이아웃.</h1>
${root }<br>
<img src="${root}/image/c3.png">
<img src="${root}/image/c4.png">

<br><br>

<img src="${root}/image/c7.png">
<img src="${root}/image/c8.png">

</body>
</html>