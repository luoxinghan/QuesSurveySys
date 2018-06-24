<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String warning = (String) request.getAttribute("warning");
	if (warning != null) {
		if (warning.equals("noUserName")) {
%>
<script>
	alert("用户名或密码错误!");
</script>
<%
		}
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./Css/AdminLogin.css" rel="stylesheet" type="text/css" />
<title>管理员登录</title>
</head>
<body>
	<div class="loginArea">
		<div class="validArea">
			<div class="loginNav">
				<p>Admin Login</p>
			</div>
			<div class="loginText">
				<form action="AdminLogin" method="post">
					用户名<br /> <input id="userName" class="userName" type="text"
						name="userName" /><br /> 密码<br /> <input id="passWord"
						class="passWord" type="text" name="passWord" /><br />
					<button class="reback BT"
						onclick="window.location.href='./index.jsp';return false;">返回主页</button>
					<input class="loginBT BT" type="submit" value="登录">
				</form>
			</div>
		</div>
	</div>
</body>
</html>