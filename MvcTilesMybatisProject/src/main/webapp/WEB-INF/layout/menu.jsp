<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
a:link, a:active, a:visited {
	color: black;
	text-decoration: none;
	cursor: pointer;
}

a:hover {
	text-decoration: underline;
	font-weight: bold;
	color: blue;
}

div.menu {
	width: 800px;
	margin-left: 200px;
	border: 1px solid black;
}

div.menu ul {
	list-style-type: none;
	margin-top: 0px;
}

div.menu ul li {
	width: 150px;
	height: 80px;
	line-height: 80px;
	font-size: 15px;
	text-align: center;
	border: 2px solid gray;
	float: left;
	margin-right: 20px;
}

div.menu ul li:hover {
	background-color: yellow;
}
</style>
</head>

<c:set var="root" value="<%=request.getContextPath()%>" />

<body>

	<div class="menu">
		<ul>
			<li><a href="${root}/home">Home</a></li>
			<li><a href="${root}/member/addform">Join</a></li>
			<li><a href="${root}/board/list">Board</a></li>
			<li><a href="${root}/mycar/list">CarInfo</a></li>
		</ul>
	</div>

</body>
</html>