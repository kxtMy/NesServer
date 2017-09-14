<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>

<body>
<script type="text/javascript" src="resources/assets/js/jquery-1.8.2.min.js"></script>
<h2>SSH</h2>
<form action="login" method="POST">
	<input id="username"/>用户名<br/>
	<input id="passwoed" type="password"/>密码<br/>
	<button type="submit">登录</button>
</form>
<button id="btn">提示</button>
<script type="text/javascript">

$(document).ready(function(){
	
	alert("提示");

});
</script>
</body>
</html>
