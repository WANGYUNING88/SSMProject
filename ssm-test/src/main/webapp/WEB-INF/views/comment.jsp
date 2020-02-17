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
        #table-table td{
            text-align: center;
        }
        #td_temp{
            border-right: 1px solid #000000;
        }
        .textarea{
            width: 435px;height: 135px;resize: none;
        }
        #image {
            width: 100px;
            height: 100px;
        }
        #image1 {
            width: 60px;
            height: 60px;
        }
    </style>
</head>
<body>
<jsp:include page="head.jsp"/>
<table id="table-table"  border="0" >
    <tr height="50px">
        <td width="200px" rowspan="4" colspan="2">
            <img id="image" src="${APP_PATH}/file/show?filename=default" alt="default" class="img-thumbnail">
        </td>
        <td width="500px" rowspan="4" colspan="5">
            <textarea class="textarea" placeholder="说点什么吧"></textarea>
        </td>
    </tr>
    <tr height="50px"></tr>
    <tr height="50px"></tr>
    <tr height="50px"></tr>
    <tr height="50px">
        <td width="200px" colspan="2">
            <b class="box-username">未登录，快去<a href="toLogin" class="alert-link">登录</a>吧</b>
        </td>
        <td width="500px" colspan="5">
            <button type="button" class="btn btn-primary" onclick="submitComment(null)">发送</button>
        </td>
    </tr>
</table>
<br>
<br>
<h4>全部评论</h4>
<!-- rowspan 是行  colspan 是列 -->
<table id="table-table" border="0" >
    <tr height="25px">
        <td width="75px" rowspan="3" rowspan="1">
            <img id="image1" src="${APP_PATH}/file/show?filename=default" alt="default" class="img-thumbnail">
        </td>
        <td width="400px" id="td_temp" colspan="4" rowspan="2" style="text-align:left;vertical-align:middle;">
            <b class="comment-content"><span id="username" user_id="#cs">未知</span>：没有人评论！</b>
        </td>
    </tr>
    <tr height="25px">


    </tr>
    <tr height="25px">
        <td width="100px" style="text-align:left;vertical-align:middle;">
            <span class="date">2020-01-01</span>
        </td>
        <td width="225px" colspan="2">
        </td>
        <td width="75px" colspan="2">
            <a class="alert-link" onclick="replyLv1();">回复</a>
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
    function submitComment(commentId) {
        if(${sessionScope.user==null}){
            alert("评论前，先登陆一下吧");
        }else {
            var content = $(".textarea").val();
            $.ajax({
                url:"comment/saveComment",
                type:"POST",
                data:{
                    content:content,
                    userOwnId:"${sessionScope.user.id}",
                    articleId:1,
                    commentId:commentId
                },
                success:function (data) {
                    console.log(data);
                    $(".textarea").val("");
                }
            });

        }
    }
    function replyLv1() {
        if(${sessionScope.user==null}){
            alert("评论前，先登陆一下吧");
        }else {
            var name = $("#username").val();
            console.log(name);
            $(".textarea").html("@"+name+"&#10");

        }
    }
    function replyLv2() {
        if(${sessionScope.user==null}){
            alert("评论前，先登陆一下吧");
        }else {

            var content = $(".textarea").val();

        }
    }
</script>
</html>
