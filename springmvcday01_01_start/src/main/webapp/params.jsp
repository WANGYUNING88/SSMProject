<%--
  Created by IntelliJ IDEA.
  User: 24719
  Date: 2020-2-1
  Time: 上午 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数绑定</title>
</head>
<body>
<h3>请求参数绑定</h3>
    <ol>
        <li>验证方法demo （<a href="param/testParam">测试</a>是否成功）</li>
        <li>传参单例多例（?后面接参数，使用&连接多个参数） （<a href="param/testParam?username=1&psd=1">测试</a>是否成功）</li>
        <li>提交表单<br>
            <form action="param/saveAccount" method="post">
                姓名：<input type="text" name="username"/><br>
                密码：<input type="text" name="psd"/><br>
                金额：<input type="text" name="money"/><br>
                用户姓名：<input type="text" name="user.uname"/><br>
                用户年龄：<input type="text" name="user.age"/><br>
                <input type="submit" value="提交">
            </form>
        </li>
    </ol>

</body>
</html>
