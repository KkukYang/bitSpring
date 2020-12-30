<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<table>
		<caption>
			<b>memberdetail page</b>
		</caption>
		<tr>
			<td>
				<h2>${dto.name }(${dto.myid })</h2>
			</td>
		</tr>
		<tr>
			<td>
				<span style="color: gray;"> 
					가입일: <fmt:formatDate value="${dto.gaipday }" pattern="yyyy-MM-dd HH:mm" />
				</span>
				<br>
				<h3>핸드폰 : ${dto.hp }</h3>
				<c:if test="${dto.photos == 'no' }">
					<h3>its nothing</h3>
				</c:if>
				<c:if test="${dto.photos != 'no' }">
					<c:forTokens var ="photo" items="${dto.photos }" delims=",">
						<img src="../save/${photo }" style="max-width: 100px;">
						<br>
					</c:forTokens>
				</c:if>
			</td>
		</tr>
		<tr>
			<td align="right">
				<button type="button" class="btn btn-info btn-sm" style="width: 90px;" 
				onclick="location.href='addform'">join</button>
				
				<button type="button" class="btn btn-info btn-sm" style="width: 90px;" 
				onclick="location.href='list'">list</button>
				
				<button type="button" class="btn btn-info btn-sm" style="width: 90px;" 
				onclick="location.href='updateform?num=${dto.num}'">edit</button>
				
				<button type="button" class="btn btn-info btn-sm" style="width: 90px;" 
				onclick="location.href='deleteform?num=${dto.num}'">delete</button>
			</td>
		</tr>
	</table>
</body>
</html>