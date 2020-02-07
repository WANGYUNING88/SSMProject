<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>员工列表</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<link
	href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script
	src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>

	<!-- 员工修改的模态框 -->
	<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="empUpdateModal">员工修改</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">empName</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="empName_update_static"></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">email</label>
							<div class="col-sm-10">
								<input type="text" name="email" class="form-control"
									id="email_update_input" placeholder="email_update_input">
								<span id="helpBlock_email" class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">gender</label>
							<div class="col-sm-10">
								<label class="radio-inline"> <input type="radio"
									name="gender" id="gender1_update_input" value="M"
									checked="checked"> 男
								</label> <label class="radio-inline"> <input type="radio"
									name="gender" id="gender2_update_input" value="W"> 女
								</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">deptName</label>
							<div class="col-sm-4">
								<!-- 部门提交did -->
								<select class="form-control" name="dId" id="dept_update_select">

								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="emp_update_btn">更新</button>
				</div>
			</div>
		</div>
	</div>



	<!-- 员工添加的模态框 -->
	<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">员工添加</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">empName</label>
							<div class="col-sm-10">
								<input type="text" name="empName" class="form-control"
									id="empName_add_input" placeholder="empName_add_input">
								<span id="helpBlock_empName" class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">email</label>
							<div class="col-sm-10">
								<input type="text" name="email" class="form-control"
									id="email_add_input" placeholder="email_add_input"> <span
									id="helpBlock_email" class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">gender</label>
							<div class="col-sm-10">
								<label class="radio-inline"> <input type="radio"
									name="gender" id="gender1_add_input" value="M"
									checked="checked"> 男
								</label> <label class="radio-inline"> <input type="radio"
									name="gender" id="gender2_add_input" value="W"> 女
								</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">deptName</label>
							<div class="col-sm-4">
								<!-- 部门提交did -->
								<select class="form-control" name="dId" id="dept_add_select">

								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="mep_save_btn">保存</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 显示页面 -->
	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>SSM-CRUD</h1>
			</div>
		</div>
		<!-- 操作按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button type="button" class="btn btn-primary" id="emp_add_modal_btn">新增</button>
				<button type="button" class="btn btn-danger" id="emp_delete_all_btn">删除</button>
			</div>
		</div>
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="emps_table">
					<thead>
						<tr>
							<th>
								<input type="checkbox" id="check_all"/>
							</th>
							<th>#</th>
							<th>empName</th>
							<th>gender</th>
							<th>email</th>
							<th>deptName</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
		<!-- 显示分页信息 -->
		<div class="row">
			<!-- 分页文字信息 -->
			<div class="col-md-6" id="page_info_area"></div>
			<!-- 分页条信息 -->
			<div class="col-md-6" id="page_nav_area"></div>
		</div>
	</div>

	<script type="text/javascript">
		//全局变量
		var pageNumMax = 1;
		var currentPage;
		//1、页面加载完成后，直接去发送ajax请求，要到分页数据
		$(function() {
			to_page(1);
		});
		//跳转到指定页的数据
		function to_page(pageNum) {
			$.ajax({
				url : "${APP_PATH}/emps",
				data : "pn=" + pageNum,
				type : "GET",
				success : function(result) {
					//console.log(result);
					//1、解析并显示员工数据
					build_emps_table(result);
					//2、解析并显示分页信息
					build_page_info(result);
					build_page_nav(result);
				}

			});
		}
		//解析并显示员工数据
		function build_emps_table(result) {
			//清空table表格
			$("#emps_table tbody").empty();
			var emps = result.extend.pageInfo.list;
			$.each(emps, function(index, item) {
				var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
				var empIdTd = $("<td></td>").append(item.empId);
				var empNameTd = $("<td></td>").append(item.empName);
				var genderTd = $("<td></td>").append(
						item.gender == "M" ? "男" : "女");
				var emailTd = $("<td></td>").append(item.email);
				var deptNameTd = $("<td></td>")
						.append(item.department.deptName);
				/**
				<button type="button" class="btn btn-primary btn-sm">
					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
					编辑
				</button>
				<button type="button" class="btn btn-danger btn-sm">
					<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
					删除
				</button>
				 */
				var editBtn = $("<button></button>").addClass(
						"btn btn-primary btn-sm edit_btn").append(
						$("<span></span>").addClass(
								"glyphicon glyphicon-pencil")).append("编辑");
				//为编辑按钮添加一个自定义属性；来表示id
				editBtn.attr("edit-id", item.empId);
				var delBtn = $("<button></button>").addClass(
						"btn btn-danger btn-sm delete_btn").append(
						$("<span></span>")
								.addClass("glyphicon glyphicon-trash")).append(
						"删除");
				delBtn.attr("delete-id", item.empId);
				var btnTd = $("<td></td>").append(editBtn).append(" ").append(
						delBtn);
				//append方法执行完后还会返回原来的元素；
				$("<tr></tr>").append(checkBoxTd).append(empIdTd).append(empNameTd).append(
						genderTd).append(emailTd).append(deptNameTd).append(
						btnTd).appendTo("#emps_table tbody");

			});
		}
		//解析并显示分页信息
		function build_page_info(result) {
			$("#page_info_area").empty();
			var pageInfo = result.extend.pageInfo;
			$("#page_info_area").append(
					"当前 " + pageInfo.pageNum + " 页，总共 " + pageInfo.pages
							+ " 页,总共 " + pageInfo.total + " 条记录");
			currentPage = pageInfo.pageNum;
			pageNumMax = pageInfo.pages;
		}
		//解析并显示分页条,并添加动作，点击跳转。。。
		function build_page_nav(result) {
			$("#page_nav_area").empty();
			var pageInfo = result.extend.pageInfo;
			//创建父元素ul
			var ul = $("<ul></ul>").addClass("pagination");
			//创建首页
			var firstPageLi = $("<li></li>").append($("<a></a>").append("首页"));
			//创建上一页
			var prePageLi = $("<li></li>").append(
					$("<a></a>").append("&laquo;"));
			if (!pageInfo.hasPreviousPage) {
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			} else {
				//为元素添加点击事件
				firstPageLi.click(function() {
					to_page(1);
				});
				prePageLi.click(function() {
					to_page(pageInfo.pageNum - 1);
				});
			}

			//将首页和上一页加入到ul
			ul.append(firstPageLi).append(prePageLi);
			var navigatepageNums = pageInfo.navigatepageNums;
			//循环遍历，并加入到ul中
			$.each(navigatepageNums, function(index, item) {
				var numList = $("<li></li>").append($("<a></a>").append(item));
				if (pageInfo.pageNum == item) {
					numList.addClass("active");
				}
				numList.click(function() {
					to_page(item);
				});
				ul.append(numList);
			});
			//创建下一页
			var nextPageLi = $("<li></li>").append(
					$("<a></a>").append("&raquo;"));
			//创建末页
			var lastPageLi = $("<li></li>").append($("<a></a>").append("末页"));
			if (!pageInfo.hasNextPage) {
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			} else {
				nextPageLi.click(function() {
					to_page(pageInfo.pageNum + 1);
				});
				lastPageLi.click(function() {
					to_page(pageInfo.pages);
				});
			}

			//将下一页和末页加入到ul中
			ul.append(nextPageLi).append(lastPageLi);
			//创建nav，并将添加ul，加入到页面中显示
			var nav = $("<nav></nav>").append(ul).appendTo("#page_nav_area");
		}

		//表单重置方法
		function reset_form(ele) {
			$(ele)[0].reset();
			//清空表单样式
			$(ele).find(".help-block").text("");
			$(ele).find("*").removeClass("has-error has-success");
		}

		//点击新增按钮，弹出模态框
		$("#emp_add_modal_btn").click(function() {
			//表单重置
			reset_form("#empAddModal form");
			//发送ajax请求，查出模态框中部门信息；
			getDepts("#dept_add_select");
			//弹出模态框
			$("#empAddModal").modal({
				backdrop : "static"
			})
		});
		//查出部门信息
		function getDepts(ele) {
			$(ele).empty();
			$.ajax({
				url : "${APP_PATH}/depts",
				type : "GET",
				success : function(result) {
					//console.log(result);
					//显示部门信息在下拉列表中
					//$("#dept_add_select").append("")
					$.each(result.extend.depts, function() {
						var optionEle = $("<option></option>").append(
								this.deptName).attr("value", this.deptId);
						optionEle.appendTo(ele);
					});
				}
			});
		}

		//校验表单数据
		function validate_add_form() {
			//empName检验
			var empName = $("#empName_add_input").val();
			var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/
			if (!regName.test(empName)) {
				shou_validate_msg("#empName_add_input", "error", "empName格式不对");
				return false;
			} else {
				shou_validate_msg("#empName_add_input", "success", "");
			}
			//邮箱校验
			var email = $("#email_add_input").val();
			var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if (!regEmail.test(email)) {
				shou_validate_msg("#email_add_input", "error", "email格式不对");
				return false;
			} else {
				shou_validate_msg("#email_add_input", "success", "");
			}
			return true;
		}
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
		//检验用户名是否可用
		$("#empName_add_input").change(
				function() {
					$.ajax({
						url : "${APP_PATH}/checkUser",
						data : "empName=" + this.value,
						type : "POST",
						success : function(result) {
							if (result.code == 100) {
								shou_validate_msg("#empName_add_input",
										"success", "empName可用");
								$("#mep_save_btn").attr("ajax-val", "success");
							} else {
								shou_validate_msg("#empName_add_input",
										"error", result.extend.va_msg);
								$("#mep_save_btn").attr("ajax-val", "error");
							}
						}
					});
				});

		//点击保存功能
		$("#mep_save_btn").click(
				function() {
					//1、模态框中填写的表单数据提交给服务器进行保存
					//2、校验数据
					if (!validate_add_form()) {
						return false;
					}
					//判断ajax用户名检验是否成功
					if ($(this).attr("ajax-val") == "error") {
						return false;
					}
					//3、发送ajax请求
					/**
					var l = $("#empAddModal form").serialize();
					l = decodeURIComponent(l,true);
					alert(l);*/
					$.ajax({
						url : "${APP_PATH}/emp",
						type : "POST",
						data : decodeURIComponent($("#empAddModal form")
								.serialize(), true),
						success : function(result) {
							//alert(result.msg);
							//员工保存成功后
							//1、关闭模态框
							$("#empAddModal").modal('hide');
							//2、显示更新的数据,去到最后一页
							//发送ajax请求最后一页
							to_page(pageNumMax + 1);
						}
					});
				});
		//1.我们是按钮创建之前就绑定了click，所以绑定不上；
		//有两种方法可以解决 1）可以在创建时绑定事件 2）使用live方法，jquery新版没有live，使用on进行替代
		$(document).on("click", ".edit_btn", function() {
			//alert("edit");
			//1.查出员工信息，并显示部门列表
			//2.查出部门信息，并显示部门列表
			getDepts("#dept_update_select");
			getEmp($(this).attr("edit-id"));
			//把员工的id传递给更新按钮
			$("#emp_update_btn").attr("edit-id", $(this).attr("edit-id"));
			$("#empUpdateModal").modal({
				backdrop : "static"
			})
		});
		//单个删除
		$(document).on("click", ".delete_btn", function() {
			//弹出是否确认框
			var empName = $(this).parents("tr").find("td:eq(2)").text();
			if (confirm("确认删除【" + empName + "】吗？")) {
				//确认删除
				$.ajax({
					url : "${APP_PATH}/emp/" + $(this).attr("delete-id"),
					type : "DELETE",
					success : function(result) {
						alert(result.msg);
						to_page(currentPage);
					}
				});
			}
		});

		function getEmp(id) {
			$.ajax({
				url : "${APP_PATH}/emp/" + id,
				type : "GET",
				success : function(result) {
					//console.log(result);
					var empData = result.extend.emp;
					$("#empName_update_static").text(empData.empName);
					$("#email_update_input").val(empData.email);
					$("#empUpdateModal input[name=gender]").val(
							[ empData.gender ]);
					$("#empUpdateModal select").val([ empData.dId ]);
					.0
				}
			});
		}

		//点击更新功能，更新员工信息
		$("#emp_update_btn")
				.click(
						function() {
							//1、校验邮箱信息
							var email = $("#email_update_input").val();
							var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
							if (!regEmail.test(email)) {
								shou_validate_msg("#email_update_input",
										"error", "email格式不对");
								return false;
							} else {
								shou_validate_msg("#email_update_input",
										"success", "");
							}
							//3、发送ajax请求
							/**
							var l = $("#empAddModal form").serialize();
							l = decodeURIComponent(l,true);
							alert(l);*/
							$.ajax({
								url : "${APP_PATH}/emp/"
										+ $(this).attr("edit-id"),
								type : "POST",
								data : decodeURIComponent($(
										"#empUpdateModal form").serialize(),
										true)
										+ "&_method=PUT",
								success : function(result) {
									//alert(result.msg);
									//员工保存成功后
									//1、关闭模态框
									$("#empUpdateModal").modal('hide');
									//回到本页面
									to_page(currentPage);
								}
							});
						});
		
		//完成全选或者全不选
		$("#check_all").click(function(){
			//attr获取checked的值是undefined；
			//我们这些dom原生的属性，attr是获取自定义的值
			//使用prop修改和读取原生属性
			$(".check_item").prop("checked",$(this).prop("checked"));
		});
		$(document).on("click",".check_item",function(){
			//判断当前选中的元素是不是满的；
			var flag = $(".check_item:checked").length==$(".check_item").length;
			$("#check_all").prop("checked",flag);
		});
		//点击全部删除，批量删除
		$("#emp_delete_all_btn").click(function() {
			var empName = "";
			var del_idstr = ""
			$.each($(".check_item:checked"),function(){
				empName += $(this).parents("tr").find("td:eq(2)").text()+",";
				del_idstr += $(this).parents("tr").find("td:eq(1)").text()+"-";
			});
			//去除最后的符号
			empName = empName.substring(0,empName.length-1);
			del_idstr = del_idstr.substring(0,empName.length-1);
			if (confirm("确认删除【" + empName + "】吗？")) {
				//确认删除
				$.ajax({
					url : "${APP_PATH}/emp/" + del_idstr,
					type : "DELETE",
					success : function(result) {
						alert(result.msg);
						to_page(currentPage);
						$("#check_all").prop("checked",false);
					}
				});
			}
		});
	</script>

</body>
</html>