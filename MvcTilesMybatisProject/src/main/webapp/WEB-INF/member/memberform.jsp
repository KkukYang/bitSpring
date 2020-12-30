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
	memberform.jsp
	<br>
	<form action="savemember" method="post" enctype="multipart/form-data">
		<table class="table table-bordered" style="width: 500px;">
			<caption>
				<b>Sign up</b>
			</caption>
			<tr>
				<th bgcolor="#ddd" style="width: 120px;">name</th>
				<td>
					<input type="text" name="name" style="width: 150px;" class="form-control" required="required">
				</td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 120px;">id</th>
				<td>
					<input type="text" name="myid" style="width: 150px;" class="form-control" required="required">
				</td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 120px;">password</th>
				<td>
					<input type="password" name="pass" style="width: 150px;" class="form-control" required="required">
				</td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 120px;">hp</th>
				<td>
					<input type="text" name="hp" style="width: 150px;" class="form-control" required="required">
				</td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 120px;">photo</th>
				<td>
					<h3>upload images.</h3>
					<input type="file" name="upload" multiple="multiple" class="form-control">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-info" style="width: 100px;">save</button>
					
					<button type="button" class="btn btn-info" style="width: 100px;"
					onclick="location.href='list'">member list</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>