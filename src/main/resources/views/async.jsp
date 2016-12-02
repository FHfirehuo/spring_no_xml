<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>servlet async support</title>
</head>
<body>

	<div id="msgFrompPush"></div>

	<script type="text/javascript"
		src="resource/js/jquery/jquery-1.12.4.min.js"></script>
	<script type="text/javascript">
		
		deferred();
		
		function deferred(){
			$.get('defer', function(data){
				console.log(data);
				deferred();
			})
		}
	</script>
</body>
</html>