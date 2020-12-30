<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>스프링MVC프로젝트(layout2)</title>
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/image/re.ico">
    <style type="text/css">
        #menu2 {
            position: absolute;
            top: 100px;
            left: 30px;
            width: 200px;
            height: 400px;
            font-size: 1.5em;
            font-weight: bold;
            text-align: center;
        }

        #main2 {
            position: absolute;
            top: 100px;
            left: 250px;
            width: 800px;
            height: 500px;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="layout2">
    <div id="menu2">
        <tiles:insertAttribute name="menu2"/>
    </div>
    <div id="main2">
        <tiles:insertAttribute name="main2"/>
    </div>
</div>

</body>
</html>