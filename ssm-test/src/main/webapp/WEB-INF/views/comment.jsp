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
            margin: 0 auto;
            text-align: center;
        }

        #image {
            padding-bottom: 100%;
        }
    </style>
</head>
<body>
<jsp:include page="head.jsp"/>
<table id="table-table" border="1px" align="center" cellpadding="10px" cellspacing="0px">
    <tr height="50px">
        <th width="200px" rowspan="4" colspan="2"></th>
        <th width="500px" rowspan="4" colspan="5"></th>
    </tr>
    <tr height="50px"></tr>
    <tr height="50px"></tr>
    <tr height="50px"></tr>
    <tr height="50px">
        <td width="200px" colspan="2"></td>
        <td width="500px" colspan="5"></td>
    </tr>
</table>
<%--
            <img id="image" src="${APP_PATH}/file/show?filename=default" alt="default" class="img-thumbnail">
--%>

</body>
<script>
    $(function () {
        console.log("${sessionScope.user}");
        /* if(

        ${sessionScope.user!=null}){
            show("

        ${sessionScope.user.image}","#image");
            $(".box-username").text("

        ${sessionScope.user.username}");
        }*/
    });

</script>
</html>
