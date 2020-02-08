<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link rel="stylesheet" href="${APP_PATH}/static/common/css/common/loading.css">
    <script type="text/javascript" src="${APP_PATH}/static/common/js/common/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/common/js/common/loading.js"></script>
</head>
<body>
<div id="loading">
    <div class="overlay"></div>
    <div id="AjaxLoading" class="showbox">
        <div class="loadingWord"><img src="${APP_PATH}/static/common/images/common/waiting.gif">加载中，请稍候...</div>
    </div>
</div>


<div style="height:1200px;">
    <h3>ceshi </h3>
</div>
</body>
<script>
    $(document).ready(function () {
        loading_start();
    });
    setTimeout(function () {
        loading_end();
    }, 800);
</script>
</html>