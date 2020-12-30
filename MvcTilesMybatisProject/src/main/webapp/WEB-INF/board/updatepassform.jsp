<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
board/updatepassform.jsp<br>
dto.num:${dto.num}<br>
pageNum:${pageNum}<br>

<form action="passcheck" method="post" class="form-inline">
    <input type="hidden" name="num" value="${dto.num}">
    <input type="hidden" name="pageNum" value="${pageNum}">
    <h3>input the password</h3>
    <div class="form-group">
        <input type="password" name="pass" class="form-control input-sm" style="width: 120px;">
        <button type="submit" class="btn btn-info">pass check</button>
    </div>

</form>

</body>
</html>