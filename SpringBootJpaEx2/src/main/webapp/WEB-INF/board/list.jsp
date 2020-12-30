<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	${message}
	<br>

	<button type="button" class="btn btn-info" style="width: 100px; margin-left: 200px;"
		onclick="location.href='carform'">input car info</button>
	<br>
	
	<br><br>
	
	<img src="c1.png">
<c:if test="${totalCount == 0}">
    <h2>저장된 차의 정보가 없습니다.</h2>
</c:if>
<c:if test="${totalCount > 0}">
    <h2>총 ${totalCount} 개의 차량정보가 있습니다.</h2>
    <table>
        <tr bgcolor="orange">
            <th width="120">num</th>
            <th width="120">carname</th>
            <th width="120">carcolor</th>
            <th width="120">carprice</th>
            <th width="120">carguip</th>
            <th width="120">edit</th>
        </tr>
        <c:forEach var="dto" items="${list}" varStatus="i">
            <tr align="center">
                <td>${i.count}</td>
                <td>${dto.carname}</td>
                <td>
                    <div style="width: 20px; height: 20px; background-color: ${dto.carcolor}; border:1px solid black;">

                    </div>
                </td>
                <td align="right">
                    <fmt:formatNumber value="${dto.carprice}" type="currency"/>
                </td>
                <td>${dto.carguip}</td>
                <td>
                    <button type="button"
                            onclick="location.href='updateform?num=${dto.num}'">edit
                    </button>
                    <button type="button"
                            onclick="location.href='delete?num=${dto.num}'">delete
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
	
</body>
</html>