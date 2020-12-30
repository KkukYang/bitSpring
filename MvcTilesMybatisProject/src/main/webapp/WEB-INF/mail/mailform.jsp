<%--
  Created by IntelliJ IDEA.
  User: yang-mac
  Date: 20. 12. 28.
  Time: 오전 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
mailform.jsp<br>

<h1>send one</h1>
<form action="mailsend1" method="post">
    <b>email addr :</b>
    <input type="text" name="emailaddr" placeholder="input email"
           value="inflearn.yangyk7364@gmail.com">
    <br>
    <input type="text" name="emailcontent">
    <br>
    <button type="submit">send email</button>
</form>
</body>
</html>
