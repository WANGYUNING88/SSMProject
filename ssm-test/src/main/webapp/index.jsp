
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
</head>
<body>

	请输入验证码：
	<input type="text" class="form-control" id="exampleInputName2"
		placeholder="请输入验证码">
	<img id="imgObj" alt="验证码" src="" onclick="changeImg()" />
	<button type="button" class="btn btn-primary btn-sm" onclick="code()">
		<span class="glyphicon glyphicon-off" aria-hidden="true"></span> 验证
	</button>
	<br>
	<div class="alert alert-success" role="alert" id="success">验证正确，<a href="${APP_PATH}/toListJsp" class="alert-link">点击此处</a>进入员工列表</div>
	<div class="alert alert-warning" role="alert" id="warning">验证码不能为空</div>
	<div class="alert alert-danger" role="alert" id="danger_100">验证码错误</div>
	<div class="alert alert-danger" role="alert" id="danger_200">系统错误</div>
	<br>
	<div class="list-group">
		<a href="toListJsp" class="list-group-item"> emps </a>
		<a href="code" class="list-group-item"> code </a>
		<a href="isCode" class="list-group-item"> isCode </a>
		<a href="toTest" class="list-group-item"> teTest </a>
		<a href="toRegister" class="list-group-item"> register </a>
		<a href="toLogin" class="list-group-item"> login </a>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		hide();
	});
	const imgUrl = "http://localhost:8080/ssmtest_war_exploded/code?timestamp=";
	changeImg();
	function hide(){
		$("#success").hide();
		$("#warning").hide();
		$("#danger_100").hide();
		$("#danger_200").hide();
	}
	function code(){
		hide();
		var code = $("#exampleInputName2").val().replace(/\s/g, "");
		if(code==""){
			$("#warning").show();
			return ;
		}
		$.ajax({
			url : "isCode",
			data : "code="+code,
			type : "GET",
			success : function(result) {
				//console.log(result);
				if(result.code==200){
					$("#danger_200").show();
				}else if(result.extend.result){
					$("#success").show();
				}else {
					$("#danger_100").show();
				}
			}
		});
		setTimeout(function(){
			changeImg();
		},500);

	}
	function changeImg() {
		var imgSrc = $("#imgObj");
		var src = imgSrc.attr("src");
		imgSrc.attr("src", chgUrl(src));
	}

	// 时间戳
	// 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
	function chgUrl(url) {
		var timestamp = (new Date()).valueOf();
		return imgUrl+timestamp;
	}
</script>
</html>
