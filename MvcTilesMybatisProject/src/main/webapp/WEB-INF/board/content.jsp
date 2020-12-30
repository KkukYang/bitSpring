<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<style type="text/css">
div.down {
	width: 400px;
	height: 50px;
	line-height: 50px;
	border: 1px solid gray;
	text-align: center;
	font-size: 1.2em;
}
</style>

</head>
<body>

	currentPage : ${currentPage}
	<br>
	<table class="table table-bordered" style="width: 700px;">
		<caption>
			<b>내용 확인</b>
		</caption>
		
		<tr>
			<td>
				<span style="font-size:2em;font-weight: bold;">
					${dto.subject}
				</span>
				<span style="float:right;color: gray;">
					<fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm"/>
				</span>
			</td>
		</tr>
		
		<tr>
			<td>
				<span style="font-size: 1.3em;color: gray;">
					${dto.writer}
				</span>	
				<span style="float:right;">
					readcount ${dto.readcount}
				</span>	
				<br><br>
				<pre style="border: none;background-color: #fff;">
					${dto.content}
				</pre>
				<br><br>
				<c:if test="${dto.upload!='no'}">
					<!-- 이미지가 아닌 파일 먼저 링크  걸기 위해서 -->
					<c:forTokens var="f" items="${dto.upload}" delims=",">
						<c:if test="${dto.isImage(f)==false}">
							<div class="down">
								<span class="glyphicon glyphicon-download-alt"/>
								<a href="../download?clip=${f}">${f}</a>
							</div><br>
						</c:if>
					</c:forTokens>
					<!-- 이번에는 이미지만 출력 -->
					<c:forTokens var="f" items="${dto.upload}" delims=",">
						<c:if test="${dto.isImage(f)==true}">
							<img src="../save/${f}" style="max-width: 400px;">
							<br>
						</c:if>
					</c:forTokens>
				</c:if>			
			</td>
		</tr>
		
		<tr>
			<td align="right">
				<button type="button" class="btn btn-info btn-sm"
				style="width: 80px;" 
				onclick="location.href='writeform'">글쓰기</button>
				
				<button type="button" class="btn btn-info btn-sm"
				style="width: 80px;" 
				onclick="location.href='writeform?num=${dto.num}&regroup=${dto.regroup}&restep=${dto.restep}&relevel=${dto.relevel}&pageNum=${pageNum}'">답글</button>
				
				<button type="button" class="btn btn-info btn-sm"
				style="width: 80px;" 
				onclick="location.href='updatepassform?num=${dto.num}&pageNum=${pageNum}'">수정</button>
				
				<button type="button" class="btn btn-info btn-sm"
				style="width: 80px;" 
				onclick="location.href='deletepassform?num=${dto.num}&pageNum=${pageNum}'">삭제</button>
				
				<button type="button" class="btn btn-info btn-sm"
				style="width: 80px;" 
				onclick="location.href='list?pageNum=${pageNum}'">목록</button>
			</td>
		</tr>


	</table>

</body>
</html>