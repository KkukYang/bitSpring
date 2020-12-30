<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
board/deletepassform.jsp<br>
num:${num}<br>
pageNum:${pageNum}<br>

<form action="passcheckanddelete" method="post" class="form-inline">
    <input type="hidden" name="num" value="${num}">
    <input type="hidden" name="pageNum" value="${pageNum}">
    <h3>input the password</h3>
    <div class="form-group">
        <input type="password" name="pass" class="form-control input-sm" style="width: 120px;">
        <button type="submit" class="btn btn-info">pass check</button>
    </div>

</form>
</body>
</html>