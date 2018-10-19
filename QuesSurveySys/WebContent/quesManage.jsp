<%@page import="com.cqut.dto.UserSurvey"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String userName = (String) request.getSession().getAttribute("userName");
	ArrayList<UserSurvey> usList = (ArrayList<UserSurvey>) request.getAttribute("usList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./Css/QsnManage.css" rel="stylesheet" type="text/css" />
<title>问卷管理</title>
</head>
<body>
	<div class="loginNav">
		<a class="curUser">欢迎管理员 <%=userName%> </a>
		<a href="ExitLogin" class="exitLogin"> 退出登录</a>
		<a href="./index.jsp" class="adLogin">回到问卷主页</a>
	</div>
	<div class="nav">
		<p class="navTitle">问卷填写记录</p>
	</div>
	<div class="qsnMid">
		<div class="operations">
			<div class="writeRecord">
				<table class="qsnTable">
					<tr class="thTr">
						<th style="width: 25%;">问卷名称</th>
						<th style="width: 20%;">填写人</th>
						<th style="width: 10%;">填写时间</th>
						<!-- <th style="width: 10%;">操作</th> -->
					</tr>
					<%
						for (int i = 0; i < usList.size(); i++) {
					%>
					<tr class="tableTr" onclick="">
						<td><%=usList.get(i).getQsnId()%></td>
						<td><%=usList.get(i).getUserId()%></td>
						<td><%=usList.get(i).getCreateTime()%></td>
						<%-- <td>
							<a class="" href="<%=path%>/QsnSurvey?id=<%=usList.get(i).getId()%>">填写详情</a>
						</td> --%>
					</tr>
					<%
						}
					%>
				</table>
			</div>
		</div>
		<!-- <div class="qsnInfo">
		</div> -->
	</div>
</body>
</html>