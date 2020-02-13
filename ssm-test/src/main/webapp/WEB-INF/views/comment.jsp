<%--
  Created by IntelliJ IDEA.
  User: 24719
  Date: 2020/2/13
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评论</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <style>

        .box-info{
            margin:0 auto; width:60%; height:40%; border:1px solid #F00
        }
        .box-info box-operate{
            padding-bottom: 100%;
        }
        #image{
            padding-bottom: 100%;
        }
    </style>
</head>
<body>
<jsp:include page="head.jsp"/>

<div class="box-info">
    <div class="box-operate">
        <span class="box-avatar">
<%--
            <img id="image" src="${APP_PATH}/file/show?filename=default" alt="default" class="img-thumbnail">
--%>
        </span>
        <b class="box-username">请<a href="toLogin" class="alert-link">登录</a></b>
        <span class="box-operate-line">|</span>
    </div>
    <div class="box-commentBtn box-commentBtn--able J_PostBtn" id="J_PostBtn" οnclick="publish_cmt();">
        发布评论
    </div>
</div>
</body>
<script>
    $(function(){
        console.log("${sessionScope.user}");
        if(${sessionScope.user!=null}){
            show("${sessionScope.user.image}","#image");
            $(".box-username").text("${sessionScope.user.username}");
        }
    });

</script>
</html>
