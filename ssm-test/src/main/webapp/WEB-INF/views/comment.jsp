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
        #table-table {
            border: 1px solid #000000;
            margin: 0 auto;
            text-align: center;
            vertical-align: middle !important;
        }
        #table-table th{
            text-align: center;
        }

        .textarea{
            width: 435px;height: 135px;resize: none;
        }
        #image {
            width: 100px;
            height: 100px;
        }
    </style>
</head>
<body>
<jsp:include page="head.jsp"/>
<table id="table-table" >
    <tr height="50px">
        <th width="200px" rowspan="4" colspan="2">
            <img id="image" src="${APP_PATH}/file/show?filename=default" alt="default" class="img-thumbnail">
        </th>
        <th width="500px" rowspan="4" colspan="5">
            <textarea class="textarea" placeholder="说点什么吧"></textarea>
        </th>
    </tr>
    <tr height="50px"></tr>
    <tr height="50px"></tr>
    <tr height="50px"></tr>
    <tr height="50px">
        <td width="200px" colspan="2">
            <b class="box-username">未登录，快去<a href="toLogin" class="alert-link">登录</a>吧</b>
        </td>
        <td width="500px" colspan="5">
            <button type="button" class="btn btn-primary" onclick="submitComment()">发送</button>
        </td>
    </tr>
</table>
</body>
<script>
    $(function () {
        console.log("${sessionScope.user}");
        if(${sessionScope.user!=null}){
            show("${sessionScope.user.image}","#image");
            $(".box-username").text("${sessionScope.user.username}");
        }
    });

    /**
     * 提交评论
     */
    function submitComment() {
        if(${sessionScope.user==null}){
            alert("评论前，先登陆一下吧");
        }else {
            var comment = $(".textarea").val();
            console.log(comment);
            $(".textarea").val("");
        }
    }
</script>
</html>
