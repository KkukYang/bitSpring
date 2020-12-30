<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--
  Created by IntelliJ IDEA.
  User: yang-mac
  Date: 2020/12/11
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Title</title>
<style type="text/css">
table, tr, th, td {
	border: 1px solid gray;
}
</style>
</head>
<body>
	memberlist
	<br> totalCount:${totalCount}
	<br> list:${list}
	<br>
	<button type="button" style="width: 100px;"
		onclick="location.href='addform'">input member info</button>
	<br>
	<br>

	<c:if test="${totalCount>0}">
		<table>
			<tr>
				<th style="width: 50px;">num</th>
				<th style="width: 100px;">mainphoto</th>
				<th style="width: 60px;">myid</th>
				<th style="width: 60px;">name</th>
				<th style="width: 100px;">hp</th>
				<th style="width: 100px;">gaipday</th>
				<th style="width: 100px;">edit</th>
			</tr>
			<c:forEach var="member" items="${list}" varStatus="i">
				<tr align="center" style="cursor: pointer;"
					onclick="location.href='detail?num=${member.num}'">
					<td>cnt:${i.count}<br>num:${member.num}<br>${member.mainphoto}</td>
					<td>
						<img src='../save/${member.mainphoto}' style="width: 90px;">
					</td>
					<td>${member.myid}</td>
					<td>${member.name}</td>
					<td>${member.hp}</td>
					<td>${member.gaipday}</td>
					<td>
						<button type="button"
							onclick="location.href='updateform?num=${dto.num}'">
							modify</button>
						<button type="button"
							onclick="location.href='delete?num=${dto.num}'">delete</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
