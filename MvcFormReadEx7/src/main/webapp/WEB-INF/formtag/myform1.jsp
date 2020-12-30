<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1>read each form data</h1>
	<form action="read1" method="post">
		<table class="table table-bordered" style="width: 300px;">
			<tr style="width: 100px;">
				<th>name</th>
				<td><input type="text" name="name" class="form-control">
				</td>
			</tr>
			<tr style="width: 100px;">
				<th>java</th>
				<td><input type="text" name="java" class="form-control">
				</td>
			</tr>
			<tr style="width: 100px;">
				<th>spring</th>
				<td><input type="text" name="spring" class="form-control">
				</td>
			</tr>
			<tr style="width: 100px;">
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-danger">send</button>
				</td>
			</tr>

		</table>

	</form>
</body>
</html>