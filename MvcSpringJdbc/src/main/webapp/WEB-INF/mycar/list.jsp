<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<button type="button" class="btn btn-info"
		style="width: 100px; margin-left: 200px;"
		onclick="location.href='carform'">input car info</button>
	<hr>

	<c:if test="${totalCount==0}">
		<span class="alert alert-info"> 저장된 데이터가 없습니다. </span>
	</c:if>
	<c:if test="${totalCount>0}">
		<span class="alert alert-info"> 총 ${totalCount} 개의 차정보가 있습니다. </span>
	</c:if>

	<br>
	<br> ${list}

	<table>
		<tr>
			<th style="width: 100px;">num</th>
			<th style="width: 100px;">carname</th>
			<th style="width: 100px;">carcolor</th>
			<th style="width: 100px;">carprice</th>
			<th style="width: 100px;">carguip</th>
			<th style="width: 100px;">edit</th>
		</tr>
		<c:forEach var="a" items="${list}" varStatus="i">
			<tr>
				<td>${i.count }</td>
				<td>${a.carname }</td>
				<td>
					<div
						style="background-color: ${a.carcolor }; width:40px;height:40px;">
					</div>
				</td>
				<td>${a.carprice }</td>
				<td>${a.carguip }</td>
				<td><a href="updateform?num=${a.num }">edit</a> <a
					href="delete?num=${a.num }">delete</a></td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>