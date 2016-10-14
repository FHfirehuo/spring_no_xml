<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
<%@include file="common/common.jsp"%>
</head>
<body>

	<font>新增一个用户:</font>
	<input value="新增" id="add" type="button">
	<br>

	<font>删除一个用户：</font>
	<input value="删除" id="delete" type="button">

	<script type="text/javascript">
		$(function() {

			$('#add').on('click', function() {

				$.ajax({
					url : "${ctx}/user/add",
					method : "POST",
					success : function(result) {
						alert(result.code);
						alert(result.message);
					}
				})
			});
			
			$('#delete').on('click', function() {

				$.ajax({
					url : "${ctx}/user/delete/1",
					method : "POST",
					success : function(result) {
						alert(result.code);
						alert(result.message);
					}
				})
			});

		});
	</script>
</body>
</html>