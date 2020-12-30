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

    <style type="text/css">
        table, tr, th, td {
            border: 1px solid gray;
        }
    </style>


</head>
<body>
writeform.jsp<br>
<br>
<form action="write" method="post" enctype="multipart/form-data">
    <input type="hidden" name="num" value="${num }">
    <input type="hidden" name="pageNum" value="${pageNum }">
    <input type="hidden" name="regroup" value="${regroup }">
    <input type="hidden" name="restep" value="${restep }">
    <input type="hidden" name="relevel" value="${relevel }">

    <table class="table table-bordered" style="width: 300px;">
        <caption>
            <b>${num==0?"new write":"reply"}</b>
        </caption>
        <tr>
            <th style="width: 120px;" bgcolor="#ddd">writer</th>
            <td>
                <input type="text" name="writer" style="width: 120px;"
                       class="form-control input-sm" required="required"
                >
            </td>
        </tr>
        <tr>
            <th style="width: 120px;" bgcolor="#ddd">password</th>
            <td>
                <input type="password" name="pass" required="required">
            </td>
        </tr>
        <tr>
            <th style="width: 120px;" bgcolor="#ddd">files</th>
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
                >
            </td>
        </tr>
        <tr>
            <td colspan="2">
					<textarea style="width: 400px;height: 100px;" name="content"
                              class="form-control input-sm" required="required"
                    ></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="submit" class="btn btn-info btn-sm"
                        style="width: 100px;"
                >save
                </button>
                <button type="button" class="btn btn-info btn-sm"
                        style="width: 100px;"
                        onclick="location.href='list?pageNum=${pageNum}'"
                >goto list
                </button>
            </td>
        </tr>

    </table>
</form>

</body>
</html>