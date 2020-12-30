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

member/updateform.jsp
	<br>
	<form action="update" method="post" enctype="multipart/form-data">
	<input type="hidden" name="num"  value="${dto.num }">
		<table class="table table-bordered" style="width: 500px;">
			<caption>
				<b>Sign up</b>
			</caption>
			<tr>
				<th bgcolor="#ddd" style="width: 120px;">name</th>
				<td>
					<input type="text" name="name" value="${dto.name }" style="width: 150px;" class="form-control" required="required">
				</td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 120px;">id</th>
				<td>
					<input type="text" name="myid" value="${dto.myid }" style="width: 150px;" class="form-control" required="required">
				</td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 120px;">password</th>
				<td>
					<input type="password" name="pass"  value="${dto.pass }" style="width: 150px;" class="form-control" required="required">
				</td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 120px;">hp</th>
				<td>
					<input type="text" name="hp"  value="${dto.hp }" style="width: 150px;" class="form-control" required="required">
				</td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 120px;">photo</th>
				<td>
					<h3>click, if you want to update</h3>
					<input type="file" name="upload" multiple="multiple" class="form-control">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-info" style="width: 100px;">update</button>
					
					<button type="button" class="btn btn-info" style="width: 100px;"
					onclick="location.href='list'">member list</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>