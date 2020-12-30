<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>
<body>

	<form action="read" method="post">
		<table class="table table-bordered" style="width: 300px;">
			<tr>
				<th bgcolor="#ddd" style="width: 100px;">carname</th>
				<td><input type="text" name="carname"></td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 100px;">carprice</th>
				<td><input type="text" name="carprice"></td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 100px;">carcolor</th>
				<td><input type="color" name="carcolor"></td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 100px;">carguip</th>
				<td><input type="date" name="carguip"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">save db</button>
					<button type="button" onclick="location.href='list'">car list</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>