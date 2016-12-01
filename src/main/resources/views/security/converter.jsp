<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="resp">
	</div>
	<input type="button" onclick="req()" value="请求">
	<script type="text/javascript"  src="resource/js/jquery/jquery-1.12.4.min.js"></script>
	<script type="text/javascript">
		function req(){
			$.ajax({
				url: "convert",
				data:"1-wangnima",
				type:"POST",
				contentType:"appliacation/x-wisely",
				success:function(data){
					$('#resp').html(data);
				}
			})
		}
	
	</script>
</body>
</html>