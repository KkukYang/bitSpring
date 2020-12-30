<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        span.msg {
            margin-left: 10px;
            margin-right: 20px;
        }

        span.writeday {
            color: gray;
            font-size: 0.8em;
            margin-right: 20px;
        }

        span.mod, span.del {
            cursor: pointer;
            margin-right: 10px;
            color: blue;
            font-size: 0.9em;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            answer_list();

            $("#camera").click(function () {
                $("#photo").trigger("click");
            });

            $("#photo").change(function () {
                // alert('file');
                var formData = new FormData();
                // var num = $("#num").val();
                var inputFile = $("#photo");
                var files = inputFile[0].files;
                for (var i = 0; i < files.length; i++) {
                    console.log(files[i].name);
                    formData.append("upload", files[i]);
                }

                // formData.append("num", num);

                $.ajax({
                    url: "photo",
                    type: "post",
                    processData: false,
                    contentType: false,
                    data: formData,
                    dataType: "json",
                    success: function (data) {
                        console.log(data);
                        $("#myimg").attr("src", "../save/" + data.photo);
                    },
                    error: function (e) {
                        console.log(e);
                    },
                });
            });

            $("#btn").click(function () {
                var num = $("#num").val();
                var msg = $("#msg").val();

                $.ajax({
                    type: "post",
                    url: "answersave",
                    data: {
                        "num": num,
                        "msg": msg
                    },
                    dataType: "html",
                    success: function (data) {
                        $("#msg").val("");
                        $("#myimg").attr("src", "");
                        answer_list();
                    },
                    error: function (e) {
                        console.log(e);
                    },
                });
            });


            $(document).on("click", "#ans-update-camera", function () {
                $("#ans-update-photo").trigger("click");
            });

            $(document).on("change", "#ans-update-photo", function () {
                // alert('file');
                var formData = new FormData();
                // var num = $("#num").val();
                var inputFile = $("#ans-update-photo");
                var files = inputFile[0].files;
                for (var i = 0; i < files.length; i++) {
                    console.log(files[i].name);
                    formData.append("upload", files[i]);
                }

                // formData.append("num", num);

                $.ajax({
                    url: "photo",
                    type: "post",
                    processData: false,
                    contentType: false,
                    data: formData,
                    dataType: "json",
                    success: function (data) {
                        console.log(data);
                        $("#ans-update-myimg").attr("src", "../save/" + data.photo);
                    },
                    error: function (e) {
                        console.log(e);
                    },
                });
            });

            $(document).on("click", "#ans-update-btn", function () {
                var num = $("#ans-update-num").val();
                var msg = $("#ans-update-msg").val();
                var idx = $("#ans-update-idx").val();

                console.log(idx, num, msg);

                $.ajax({
                    type: "post",
                    url: "answerupdate",
                    data: {
                        "num": num,
                        "msg": msg,
                        "idx": idx,
                    },
                    dataType: "html",
                    success: function (data) {
                        console.log(data);
                        $("#ans-update-msg").val("");
                        $("#ans-update-myimg").attr("src", "");
                        $("#myModal").modal("hide");
                        answer_list();
                    },
                    error: function (e) {
                        console.log(e);
                    },
                });
            });


            $(document).on("click", "span.mod", function () {
                var idx = $(this).attr("idx");
                // alert(idx);
                $("#myModal").modal();
                $("#myModal #ans-update-idx").val(idx);
                console.log($("#myModal #ans-update-idx").val());
            });

            $(document).on("click", "span.del", function () {
                var idx = $(this).attr("idx");
                var result = confirm("delete? : " + idx);

                if (result) {
                    $.ajax({
                        type: "post",
                        url: "answerdelete",
                        data: {
                            "idx": idx,
                        },
                        dataType: "html",
                        success: function (data, data2, data3) {
                            console.log(data, data2, data3);
                            answer_list();
                        },
                        error: function (e) {
                            console.log(e);
                        },
                    });
                }
            });
        }); //$(function()...

        function answer_list() {
            var num = $("#num").val();
            $.ajax({
                type: "get",
                url: "answerlist",
                dataType: "json",
                data: {
                    "num": num,
                },
                success: function (data) {
                    console.log(data);
                    var s = "<div>";

                    $.each(data, function (i, n) {
                        if (n.photoname != "no") {
                            s += "<img src='../save/" + n.photoname + "' style='max-height: 30px;'>";
                        }
                        s += "<span class='msg'>" + n.msg + "</span>";
                        s += "<span class='writeday'>" + n.writeday + "</span>";
                        s += "<span class='mod' idx=" + n.idx + ">edit</span>";
                        s += "<span class='del' idx='" + n.idx + "'>delete</span>";
                        s += "<br>";
                    });

                    s += "</div>";
                    $("#answer").html(s);
                },
                error: function (e) {
                    console.log(e);
                },
            });
        }

    </script>
</head>
<body>

pageNum:${pageNum}<br>
dto.upload:${dto.upload}<br>
dto.num:${dto.num}<br>
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
            <c:if test="${dto.upload != 'no'}">
                <!-- 이미지가 아닌 파일 먼저 링크 걸기 위해서 -->
                <c:forTokens var="f" items="${dto.upload}" delims=",">
                    <c:if test="${dto.isImage(f)==false}">
                        <div class="down">
                            <span class="glyphicon glyphicon-download-alt"/>
                            <a href="../download?clip=${f}">${f}</a>
                        </div>
                        <br>
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
        <td>
            <a id="alist"></a>
            <%--print reply--%>
            <div id="answer">

            </div>

            <%--reply form--%>
            <div class="form-inline form-group">
                <input type="hidden" id="num" value="${dto.num}">
                <input type="text" class="form-control input-sm" id="msg" placeholder="input reply"
                       style="width: 400px;">
                <input type="file" class="form-control" id="photo" style="width: 200px; display: none;">
                <span class="glyphicon glyphicon-camera" id="camera" style="font-size: 1.5em;"></span>
                <input type="button" id="btn" class="btn btn-success btn-sm" value="save">
                <img alt="" src="" id="myimg">
            </div>
        </td>
    </tr>

    <tr>
        <td align="right">
            <button type="button" class="btn btn-info btn-sm"
                    style="width: 80px;"
                    onclick="location.href='writeform'">글쓰기
            </button>

            <button type="button" class="btn btn-info btn-sm"
                    style="width: 80px;"
                    onclick="location.href='writeform?num=${dto.num}&regroup=${dto.regroup}&restep=${dto.restep}&relevel=${dto.relevel}&pageNum=${pageNum}'">
                답글
            </button>

            <button type="button" class="btn btn-info btn-sm"
                    style="width: 80px;"
                    onclick="location.href='updatepassform?num=${dto.num}&pageNum=${pageNum}'">수정
            </button>

            <button type="button" class="btn btn-info btn-sm"
                    style="width: 80px;"
                    onclick="location.href='deletepassform?num=${dto.num}&pageNum=${pageNum}'">삭제
            </button>

            <button type="button" class="btn btn-info btn-sm"
                    style="width: 80px;"
                    onclick="location.href='list?pageNum=${pageNum}'">목록
            </button>
        </td>
    </tr>
</table>

<%--bootStrap Modal--%>
<div class="container">
    <%--    <h2>Modal Login Example</h2>--%>
    <%--    <!-- Trigger the modal with a button -->--%>
    <%--    <button type="button" class="btn btn-default btn-lg" id="myBtn">Login</button>--%>

    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header" style="padding:22px 22px;">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <span class="glyphicon glyphicon-lock"></span> Update
                </div>
                <div class="modal-body" style="padding:40px 50px;">
                    <div class="form-inline form-group">
                        <input type="hidden" id="ans-update-idx" value="">
                        <input type="hidden" id="ans-update-num" value="${dto.num}">
                        <input type="text" class="form-control input-sm" id="ans-update-msg"
                               placeholder="input reply"
                               style="width: 400px;">
                        <input type="file" class="form-control" id="ans-update-photo"
                               style="width: 200px; display: none;">
                        <span class="glyphicon glyphicon-camera" id="ans-update-camera"
                              style="font-size: 1.5em;"></span>
                        <input type="button" id="ans-update-btn" class="btn btn-success btn-sm"
                               value="save">
                        <img alt="" src="" id="ans-update-myimg">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal">
                        <span class="glyphicon glyphicon-remove"></span> Cancel
                    </button>
                </div>
            </div>

        </div>
    </div>
</div>


</body>
</html>