<%--
  Created by IntelliJ IDEA.
  User: 24719
  Date: 2020-2-7
  Time: 下午 06:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
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
        .form-group img {
            width: 150px;
            height: 150px;
        }
    </style>
</head>
<body>
<!--引入头部JSP-->
<jsp:include page="head.jsp"></jsp:include>
<!-- loading -->
<div class="overlay"></div>
<div id="AjaxLoading" class="showbox">
    <div class="loadingWord"><img src="${APP_PATH}/static/common/images/common/waiting.gif">正在上传图片，请务刷新</div>
</div>

<!-- main -->
<div class="form-group">
    <label for="exampleInputName1">Username</label>
    <input type="email" class="form-control" id="exampleInputName1" placeholder="Username">
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
        <img id="image" src="${APP_PATH}/file/show?filename=default" alt="default" class="img-thumbnail">
        <input onchange="upload('#exampleInputFile','#image')" name="file" type="file" id="exampleInputFile"
               accept=".jpg,.jpeg,.png"/>
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
        var psd1 = $("#exampleInputPassword1").val();
        var psd2 = $("#exampleInputPassword2").val();
        if (psd1 == psd2) {
            var username = $("#exampleInputName1").val();
            var image = $("#image").prop("alt");
            console.log("【pas:】" + psd1);
            console.log("【username:】" + username);
            console.log("【image:】" + image);
            $.ajax({
                url: "user/register",
                type:"post",
                data:{
                    "username":username,
                    "password":psd1,
                    "image":image
                },
                success:function (data) {
                    console.log(data);
                }
            });

        } else {
            alert("密码不一致");
        }
    });


</script>
</html>

