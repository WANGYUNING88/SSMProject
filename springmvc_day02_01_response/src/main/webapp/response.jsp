<%--
  Created by IntelliJ IDEA.
  User: 24719
  Date: 2020-2-3
  Time: 上午 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RESPONSE</title>
    <script src="js/jquery.min.js"></script>
    <script>
        //页面加载，绑定单击事件
        $(function () {
            $("#btn").click(function () {
                //alert("hello btn");
                //发送ajax请求
                $.ajax({
                    //编写json格式设置属性和值
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"王","psd":"123","age":20}',
                    dataType:"json",
                    type:"POST",
                    success:function (result) {
                        //result:服务器返回的json数据。进行解析
                        alert(result.toString());
                    }
                });
            });
        });
    </script>
</head>
<body>

<h2>Day02</h2>
    <ol>
        <li>
            testString-->【<a href="user/testString">TEST</a>】
        </li>
        <li>
            testVoid-->【<a href="user/testVoid">TEST</a>】
        </li>
        <li>
            ModelAndView-->【<a href="user/testModelAndView">TEST</a>】
        </li>
        <li>
            ForwardOrRedirect-->【<a href="user/testForwardOrRedirect">TEST</a>】
        </li>
        <li>
            发送ajax请求--><button id="btn">测试</button>
        </li>

    </ol>

</body>
</html>
