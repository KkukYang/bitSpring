<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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

</head>
<body>
board/updateform.jsp<br>
currentPage : ${currentPage}<br>
pageNum : ${pageNum}<br>
dto.num : ${dto.num}<br>
<br>
<form action="update" method="post" enctype="multipart/form-data">
    <input type="hidden" name="num" value="${dto.num}">
    <input type="hidden" name="pageNum" value="${pageNum }">

    <table class="table table-bordered" style="width: 300px;">
        <caption>
            <b>edit</b>
        </caption>
        <tr>
            <th style="width: 120px;" bgcolor="#ddd">writer</th>
            <td>
                <input type="text" name="writer" style="width: 120px;"
                       class="form-control input-sm" required="required"
                       value="${dto.writer}"
                >
            </td>
        </tr>
        <tr>
            <th style="width: 120px;" bgcolor="#ddd">file upload</th>
            <td>
                <input type="file" name="files" multiple="multiple"
                       class="form-control input-sm"
                >
            </td>
        </tr>
        <tr>
            <th style="width: 120px;" bgcolor="#ddd">subject</th>
            <td>
                <input type="text" name="subject"
                       class="form-control input-sm" required="required"
                       value="${dto.subject}"
                >
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <textarea style="width: 400px;height: 100px;" name="content"
                          class="form-control input-sm" required="required"
                >${dto.content}</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="submit" class="btn btn-info btn-sm"
                        style="width: 100px;"
                >
                    save
                </button>
                <button type="button" class="btn btn-info btn-sm"
                        style="width: 100px;"
                        onclick="location.href='list?pageNum=${pageNum}'"
                >
                    goto list
                </button>
            </td>
        </tr>
    </table>
</form>

</body>
</html>