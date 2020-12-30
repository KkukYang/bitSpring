<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>

	<pre>
	<h2>
"public String formRead2(@ModelAttribute ShopDto dto)"
sang : ${shopDto.sang }
su : ${shopDto.su }
dan :  <fmt:formatNumber value="${shopDto.dan }" type="currency" /> 
	</h2>
	<h3>
"public String formRead2(@ModelAttribute("dto") ShopDto dto)"
sang : ${dto.sang }
su : ${dto.su }
dan :  <fmt:formatNumber value="${dto.dan }" type="currency" /> 
	</h3>
</pre>

</body>
</html>