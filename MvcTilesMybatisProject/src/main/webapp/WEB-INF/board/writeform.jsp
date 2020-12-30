<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	table, tr, th, td {
		border: 1px solid gray;
	}
</style>


</head>
<body>
	writeform.jsp<br>
	<form action="write" method="post" enctype="multipart/form-data">
		<input type="hidden" name="num" value="${num }">
		<input type="hidden" name="pageNum" value="${pageNum }">
		<input type="hidden" name="regroup" value="${regroup }">
		<input type="hidden" name="restep" value="${restep }">
		<input type="hidden" name="relevel" value="${relevel }">
	
		<table style="width: 300px;">
			<caption>
				<b>${num==0?"new write":"reply"}</b>
			</caption>
			<tr>
				<th>name</th>
				<td>
					<input type="text" name="writer" required="required">
				</td>
			</tr>
			<tr>
				<th>password</th>
				<td>
					<input type="password" name="password" required="required">
				</td>
			</tr>
			<tr>
				<th>files</th>
				<td>
					<input type="file" name="files" multiple="multiple" required="required">
				</td>
			</tr>
			<tr>
				<th>subject</th>
				<td>
					<input type="text" name="subject" required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea name="content" required="required"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">save</button>
					<button type="button"
						onclick="location.href='list?pageNum=${pageNUm}'"
					>goto list</button>
				</td>
			</tr>
			
		</table>
	</form>

</body>
</html>