<%@ page language="java" import="java.util.*" import="com.cqut.dao.QuestionnaireDao" 
	import="com.cqut.dto.Questionnaire" import="java.net.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	InetAddress address = InetAddress.getLocalHost();
	String hostAddress = address.getHostAddress();
	
	ArrayList<Questionnaire> qsnList = QuestionnaireDao.getQuestionnaireDao().getQuestionnaire();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./Css/QuesSurvey.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="./Ui/font-awesome-4.7.0/css/font-awesome.min.css">
<title>问卷调查系统</title>
</head>
<body>
	<div class="loginNav">
		<a class="curUser">当前用户 <%=hostAddress%></a> <a
			href="./adminLogin.jsp" class="adLogin">管理员登录</a>
	</div>
	<div class="nav">
		<p class="navTitle">问卷调查系统</p>
	</div>
	<div class="mid">
		<div class="operations">
			<div class="buttonArea">
				<button onclick="addTeacher()" class="addBT BT">新增</button>
				<button class="delBT BT" style="display: none;">删除</button>
			</div>
			<div class="tableArea">
				<table class="qsnTable">
					<tr class="thTr">
						<th	style="width: 35%;">问卷名称</th>
						<th style="width: 10%;">创建时间</th>
						<th style="width: 10%;">结束时间</th>
						<th style="width: 15%;">创建人</th>
						<th style="width: 20%;">操作</th>
					</tr>
					<%
 						for(int i = 0; i < qsnList.size(); i++){ 
 					%>
					<tr class="tableTr" onclick="">
						<td><%=qsnList.get(i).getQsnName() %></td>
						<td><%=qsnList.get(i).getCreateTime() %></td>
						<td><%=qsnList.get(i).getEndTime() %></td>
						<td><%=qsnList.get(i).getAuthor() %></td>
						<td>
							<!-- <a onclick="viewTeacher(this)"><span class="fa fa-eye fa-lg pointer"></span></a>&nbsp;&nbsp;&nbsp;&nbsp; -->
							<a onclick="updateTeacher(this)"><span class='fa fa-pencil fa-lg pointer'></span></a><!-- &nbsp;&nbsp;&nbsp;&nbsp; -->
							<!-- <a onclick="deleteTeacher(this)"><span class='fa fa-trash fa-lg pointer'></span></a> -->
						</td>
					</tr>
 					<%
 						}
 					%>
				</table>
			</div>
		</div>
	</div>
</body>
</html>