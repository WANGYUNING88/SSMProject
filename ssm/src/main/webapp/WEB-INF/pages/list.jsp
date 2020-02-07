<%--
  Created by IntelliJ IDEA.
  User: 24719
  Date: 2020-2-5
  Time: 下午 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>查询全部</h3>
    ${list}

<h3>列表</h3>
<c:forEach items="${list}"var="account">
    ${account.name}
</c:forEach>


</body>
</html>
