<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Latest compiled and minified CSS -->
<!-- <link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"> -->
<title>스프링MVC프로젝트(layout1)</title>
<style type="text/css">
#top {
	position: absolute;
	top: 0px;
	left: 0px;
	width: 100%;
	height: 150px;
	line-height: 150px;
	font-size: 2em;
	font-weight: bold;
	text-align: center;
	border:1px solid black;
}
#menu {
	position: absolute;
	top: 160px;	left: 0px;
	width: 100%;
	height: 100px;
	line-height: 150px;
	font-size: 2em;
	font-weight: bold;
	text-align: center;
	border:1px solid black;
}
#info {
	position: absolute;
	top: 270px;	left: 5px;
	width: 200px;
	height: 100px;
	font-size: 1.5em;
	font-weight: bold;
	text-align: center;
	border:1px solid black;
}
#main {
	position: absolute;
	top: 270px;	left: 240px;
	width: 800px;
	height: 500px;
	font-weight: bold;
	border:1px solid black;
}
</style>
</head>
<body>

	<div class="layout">
		<div id="top">
			<tiles:insertAttribute name="top" />
		</div>
		<div id="menu">
			<tiles:insertAttribute name="menu" />
		</div>
		<div id="main">
			<tiles:insertAttribute name="main" />
		</div>
		<div id="info">
			<tiles:insertAttribute name="info" />
		</div>
	</div>


</body>
</html>