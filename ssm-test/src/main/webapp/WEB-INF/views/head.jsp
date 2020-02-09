<%--
  Created by IntelliJ IDEA.
  User: 24719
  Date: 2020-2-8
  Time: 上午 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>

    <!-- Bootstrap -->
    <link
            href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
            rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script
            src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script
            src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js">

    </script>

    <link rel="stylesheet" href="${APP_PATH}/static/common/css/common/loading.css">
    <script type="text/javascript" src="${APP_PATH}/static/common/js/common/loading.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/common/js/common/fileutils.js"></script>
    <script>
        //显示检验结果
        function shou_validate_msg(ele, status, msg) {
            $(ele).parent().removeClass("has-success has-error");
            $(ele).next("span").text("");
            if ("success" == status) {
                $(ele).parent().addClass("has-success");
                $(ele).next("span").text(msg);
            } else if ("error" == status) {
                $(ele).parent().addClass("has-error");
                $(ele).next("span").text(msg);
            }
        }
    </script>
</head>
<body>
    <h3>公共头jsp</h3>
</body>
</html>
