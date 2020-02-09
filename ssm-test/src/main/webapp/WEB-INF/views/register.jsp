<%--
  Created by IntelliJ IDEA.
  User: 24719
  Date: 2020-2-7
  Time: 下午 06:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"  pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <style>
        .form-group img{
            width:150px;
            height:150px;
        }
    </style>
</head>
<body>
<!--引入头部JSP-->
<jsp:include page="head.jsp"></jsp:include>
<div class="form-group">
    <label for="exampleInputEmail1">Username</label>
    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Username">
</div>
<div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
</div>
<div class="form-group">
    <label for="exampleInputPassword2">Password Again</label>
    <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password Again">
</div>
<form enctype="multipart/form-data" id="fileForm">
    <div class="form-group">
        <label for="exampleInputFile">Image input</label><br>
        <img id="image" src="${APP_PATH}/static/common/images/common/image.jpeg" alt="头像" class="img-thumbnail">
        <input onchange="upload()" name="file" type="file" id="exampleInputFile" accept=".jpg,.jpeg,.png"/>
    </div>
</form>
   <%-- <div class="checkbox">
        <label>
            <input type="checkbox"> ${APP_PATH}
        </label>
    </div>--%>
<button type="button" id="register" class="btn btn-default">Submit</button>
</body>
<script>
    $("#register").click(function () {

    });

    /**
     * 头像上传
     */
    function upload(){
        var formData = new FormData();
        var files = document.getElementById("exampleInputFile").files;
        if(files.length==0)
            return;
        formData.append("fileName", files[0]);
        $.ajax({
            url : "file/upload",
            type : "POST",
            data : formData,
            contentType : false,
            processData : false,
            success : function(result) {

            },
        });
        //return filename;
    }
</script>
</html>

