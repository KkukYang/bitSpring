<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="update" method="post">
		<input type="hidden" name="num" value="${dto.num }">
		<table class="table table-bordered" style="width: 300px;">
			<tr>
				<th bgcolor="#ddd" style="width: 100px;">carname</th>
				<td><input type="text" name="carname" value="${dto.carname }"></td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 100px;">carprice</th>
				<td><input type="text" name="carprice" value="${dto.carprice }"></td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 100px;">carcolor</th>
				<td><input type="color" name="carcolor" value="${dto.carcolor }"></td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 100px;">carguip</th>
				<td><input type="date" name="carguip" value="${dto.carguip }"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">update db</button>
					<button type="button" onclick="location.href='list'">car
						list</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>