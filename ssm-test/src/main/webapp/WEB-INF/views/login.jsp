<%--
  Created by IntelliJ IDEA.
  User: 24719
  Date: 2020/2/12
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <style>
        #image {
            width: 150px;
            height: 150px;
        }
    </style>
</head>
<body>
<jsp:include page="head.jsp"/>
<div class="overlay"></div>
<div id="AjaxLoading" class="showbox">
    <div class="loadingWord"><img src="${APP_PATH}/static/common/images/common/waiting.gif">正在跳转（<a href="toComment" class="alert-link">手动跳转</a>）</div>
</div>
<form>
    <div class="form-group">
        <img id="image" src="${APP_PATH}/file/show?filename=default" alt="default" class="img-thumbnail">
    </div>
    <div class="form-group">
        <label for="inputUsername3" class="col-sm-2 control-label">Username</label>
        <div class="col-sm-10">
            <input type="email" class="form-control" id="inputUsername3" placeholder="Username">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <div class="checkbox">
                <label>
                    <input type="checkbox"> Remember me
                </label>
            </div>
        </div>
    </div>

    <button type="button" class="btn btn-default" id="login">Sign in</button>


</form>
<div class="alert alert-info" role="alert">
    <strong>没有账号</strong> 我需要 <a href="toRegister" class="alert-link">注册</a>一个。
</div>
</body>
<script>
    /**
     * 获取头像
     */
    $("#inputUsername3").blur(function () {
        var username = $(this).val();
        if (username==null||username.length==0)
            return;
        $.ajax({
            url:"user/selectImageByUsername",
            type:"post",
            data:{
                "username":username
            },
            success:function (data) {
                console.log(data);
                if (data.code==100){
                    show(data.extend.filename,"#image");
                }else if (data.code==200){
                    alert("用户名错误或不存在！");
                    show(data.extend.filename,"#image");
                }
            }
        });
    });
    /**
     * 登录
     */
    $("#login").click(function () {
        var username = $("#inputUsername3").val();
        var password = $("#inputPassword3").val();
        $.ajax({
            url:"user/login",
            type: "post",
            data:{
                "username":username,
                "password":password,
            },
            success:function (data) {
                console.log(data);
                if(data.code==100){
                    loading_start();
                    setTimeout(function () {
                        window.location = "toComment";
                    },5000);
                }else if(data.code==200){
                    alert("密码错误！");
                }
            }
        });
    });
</script>
</html>
