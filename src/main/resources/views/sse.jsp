<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SSe demo</title>
</head>
<body>

	<div id="msgFrompPush"></div>

	<script type="text/javascript"
		src="resource/js/jquery/jquery-1.12.4.min.js"></script>
	<script type="text/javascript">
		if (!!window.EventSource) {
			var source = new EventSource('push');
			s = '';
			
			source.addEventListener('message', function(e) {
				console.log("message");
				s += e.data + "<br/>";
				$('#msgFrompPush').html(s);
			});

			source.addEventListener('open', function(e) {
				console.log("链接打开.");
			}, false);

			source.addEventListener('error', function(e) {

				if (e.currentTarget.readyState == EventSource.CLOSED) {
					console.log("链接关闭");
				} else {
					console.log('error' +e.currentTarget.readyState );
				}
			}, false);

		} else {
			console.log("你的浏览器不支持SSE");
		}
	</script>
</body>
</html>