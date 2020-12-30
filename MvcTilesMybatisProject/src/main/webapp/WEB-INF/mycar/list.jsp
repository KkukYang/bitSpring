<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: yang-mac
  Date: 2020/12/10
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table, tr, th, td {
            border: 1px solid gray;
        }
    </style>
</head>
<body>
<button type="button" style="width: 100px;" onclick="location.href='carform'">
    input car info
</button>
<br><br>
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
