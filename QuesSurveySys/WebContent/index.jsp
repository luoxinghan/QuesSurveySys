<%@ page language="java" import="java.util.*" import="java.net.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	InetAddress address = InetAddress.getLocalHost();
	String hostAddress = address.getHostAddress();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./Css/QuesSurvey.css" rel="stylesheet" type="text/css" />
<title>问卷调查系统</title>
</head>
<body>
	<div class="loginNav">
		<a class="curUser">当前用户 <%=hostAddress %></a>
		<a href="./adminLogin.jsp" class="adLogin">管理员登录</a>
	</div>
	<div class="nav">
		<p class="navTitle"> 问卷调查系统</p>
	</div>
	<form action=""></form>
</body>
</html>