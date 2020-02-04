<%--
  Created by IntelliJ IDEA.
  User: 24719
  Date: 2020-2-4
  Time: 下午 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fileupload</title>
</head>
<body>
    <h3>文件上传</h3>
    <ol>
        <li>
            <span>传统上传思路</span><br>
            <form action="file/fileupload1" method="post" enctype="multipart/form-data">
                选择文件：<input type="file" name="upload"/><br>
                <input type="submit" value="上传"/>

            </form>
        </li>
        <li>
            <span>springMVC上传思路</span><br>
            <form action="file/fileupload2" method="post" enctype="multipart/form-data">
                选择文件：<input type="file" name="upload"/><br>
                <input type="submit" value="上传"/>

            </form>
        </li>
        <li>
            <span>跨服务器上传文件</span><br>
            <form action="file/fileupload3" method="post" enctype="multipart/form-data">
                选择文件：<input type="file" name="upload"/><br>
                <input type="submit" value="上传"/>

            </form>
        </li>
    </ol>


</body>
</html>
