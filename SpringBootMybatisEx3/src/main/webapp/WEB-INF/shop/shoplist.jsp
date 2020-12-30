<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
	totalCount : ${totalCount}
	<br>

	<button type="button" class="btn btn-info"
		style="width: 200px; margin-left: 20px;"
		onclick="location.href='form'">input shop info</button>
	<br>

	<c:if test="${totalCount == 0}">
		<div class="alert alert-info">
			<b>nothing to print data.</b>
		</div>
	</c:if>

	<c:if test="${totalCount > 0}">
		<b>totalCount : ${totalCount}</b>

		<table class="table table-bordered" style="width: 700px;">
			<tr bgcolor="orange">
				<th width="120">sangpum</th>
				<th width="120">price</th>
				<th width="120">photoname</th>
				<th width="120">ipgoday</th>
				<th width="120">edit</th>
			</tr>
			<c:forEach var="dto" items="${list}" varStatus="i">
				<tr align="center">
					<td>${dto.sangpum}</td>
					<td align="right">
					<fmt:setLocale value="ko_kr"/>
					<%-- currencySymbol="원"  currencyCode="KRW" --%>
						<fmt:formatNumber value="${dto.price}" type="currency" currencySymbol="(원) "/></td>
					<td>${dto.photoname}<img src="photo/${dto.photoname}"
						width="100">
					</td>
					<td>${dto.ipgoday}</td>
					<td>
						<button type="button"
							onclick="location.href='updateform?num=${dto.num}'">modify
						</button>
						<button type="button"
							onclick="location.href='delete?num=${dto.num}'">delete</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>