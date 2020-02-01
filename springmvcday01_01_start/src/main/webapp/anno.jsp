<%--
  Created by IntelliJ IDEA.
  User: 24719
  Date: 2020-2-1
  Time: 下午 07:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>常用注解</title>
</head>
<body>
    <h3>常用注解</h3>
    <ol>
        <li>RequestParam请求参数 （<a href="anno/testRequestParam?name=测试">测试</a>是否成功）</li>
        <li>RequestBody请求体 <br>
            <form action="anno/testRequestBody" method="post">
                用户姓名：<input type="text" name="username"/><br>
                用户年龄：<input type="text" name="age"/><br>
                <input type="submit" value="提交">
            </form>
        </li>
        <li>PathVariable请求地址中的占位符 （<a href="anno/testPathVariable/202021">测试</a>是否成功）</li>
        <li>Restful <br>
            <ol>
                <li>
                    <form action="anno/testRestfulGET/190305" method="post">
                        用户姓名：<input type="text" name="username"/><br>
                        <input type="hidden" name="_method" value="GET"/><br>
                        <input type="submit" value="GET">
                    </form>
                </li>
                <li>
                    <form action="anno/testRestfulPOST/190305" method="post">
                        用户姓名：<input type="text" name="username"/><br>
                        <input type="hidden" name="_method" value="POST"/><br>
                        <input type="submit" value="POST">
                    </form>
                </li>
                <li>
                    <form action="anno/testRestfulDELETE/190305" method="post">
                        用户姓名：<input type="text" name="username"/><br>
                        <input type="hidden" name="_method" value="DELETE"/><br>
                        <input type="submit" value="DELETE">
                    </form>
                </li>
                <li>
                    <form action="anno/testRestfulPUT/190305" method="post">
                        用户姓名：<input type="text" name="username"/><br>
                        <input type="hidden" name="_method" value="PUT"/><br>
                        <input type="submit" value="PUT">
                    </form>
                </li>
            </ol>

        </li>
    </ol>
</body>
</html>
