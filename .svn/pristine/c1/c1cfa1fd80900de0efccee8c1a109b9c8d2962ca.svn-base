<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!--  静态包含不能使用 c标签-->
<%@include file="../common/common.jsp"%>
</head>


<body onload="document.username.focus()">
	<div class="container">
		<div class="navbar">
			<div class="navbar-inner">
				
				<ul class="nav">
					<li><a  href="javascript:;"> Home </a></li>
				</ul>
			</div>
		</div>
		<div class="content">

			<h2>Login with Username and Password</h2>
			<fieldset>
				<font>用户名：</font><input type="text" id="username" name="username"
					value="" placeholder="Username" /> <font>密 码：</font><input
					type="password" id="password" name="password"
					placeholder="Password" />
			</fieldset>
			<input type="button" id="login" value="登录" class="btn btn-primary" />

		</div>
	</div>

	<script type="text/javascript">
		/* var ctx = "${ctx}";
		alert(ctx); */

		$(function() {

			$('#login').on('click', function() {

				var un = $('#username').val().trim();
				var pw = $('#password').val().trim();

				if (!un) {
					alert("账号不能为空");
					return false;
				}

				if (!pw) {
					alert("密码不能为空");
					return false;
				}

				$.ajax({
					url : "${ctx}/login",
					method : "POST",
					data : {
						username : un,
						password : pw
					},
					success : function(result) {
						if (result.code) {
							window.location.href = "${ctx}/home";
						}
					}
				})
			});

		});
	</script>
</body>
</html>