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
        <li>提交表单(1) 单例  <br>
            *把数据封装到Account类中*<br>
            <form action="param/saveAccount" method="post">
                姓名：<input type="text" name="username"/><br>
                密码：<input type="text" name="psd"/><br>
                金额：<input type="text" name="money"/><br>
                用户姓名：<input type="text" name="user.uname"/><br>
                用户年龄：<input type="text" name="user.age"/><br>
                <input type="submit" value="提交">
            </form>
        </li>
        <li>提交表单(2)集合<br>
            *把数据封装到Account类中，类中存在list和map集合*<br>
            <form action="param/saveAccount" method="post">
                姓名：<input type="text" name="username"/><br>
                密码：<input type="text" name="psd"/><br>
                金额：<input type="text" name="money"/><br>
                用户1姓名：<input type="text" name="list[0].uname"/><br>
                用户1年龄：<input type="text" name="list[0].age"/><br>
                用户2姓名：<input type="text" name="map['one'].uname"/><br>
                用户2年龄：<input type="text" name="map['one'].age"/><br>
                <input type="submit" value="提交">
            </form>
        </li>
        <li>提交表单(3)自定义类型转化器<br>
            *把数据封装到User类中,包含日期*<br>
            <form action="param/saveUser" method="post">
                用户姓名：<input type="text" name="uname"/><br>
                用户年龄：<input type="text" name="age"/><br>
                用户生日：<input type="date" name="date"/><br>
                <input type="submit" value="提交">
            </form>
        </li>
        <li>Servlet原生的API （<a href="param/testServlet">测试</a>）</li>
    </ol>

</body>
</html>
