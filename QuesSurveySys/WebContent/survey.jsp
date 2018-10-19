<%@page import="com.cqut.dao.UserDao"%>
<%@page import="com.cqut.dto.Option"%>
<%@page import="com.cqut.dto.Question"%>
<%@page import="com.cqut.dto.Questionnaire" import="java.net.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Questionnaire qsn = (Questionnaire) request.getAttribute("qsn");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	InetAddress address = InetAddress.getLocalHost();
	String hostAddress = address.getHostAddress();
	Question ques = new Question();
	Option op = new Option();
	String isRequired;
	Byte questionType;
	String opType = "radio";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./Css/Survey.css" rel="stylesheet" type="text/css" />
<title><%=qsn.getQsnName()%></title>
</head>
<body>
	<div class="loginNav">
		<a class="curUser">当前用户 <%=hostAddress%></a> <a
			href="./adminLogin.jsp" class="adLogin">管理员登录</a>
	</div>
	<div class="nav">
		<p class="navTitle">问卷调查系统</p>
	</div>
	<div class="qsnMid">
		<div class="qsnInfo">
			<div class="qsnHead">
				<p class="title"><%=qsn.getQsnName()%></p>
				<p class="detail"><%=qsn.getQsnDescribe()%></p>
			</div>

			<div class="qsnBody">
				<form action="Submit" method="get">
					<%
						boolean isExist = UserDao.getUserDao().isUserExistUserName(hostAddress, qsn.getId());
						for (int i = 0; i < qsn.getQuestions().size(); i++) {
					%>
					<div class="quesBody">
						<%
								ques = qsn.getQuestions().get(i);
								questionType = ques.getQuestionType();
								if (questionType == 0) {
									opType = "radio";
								} else if (questionType == 1) {
									opType = "checkbox";
								} else if (questionType == 2) {
									opType = "text";
								}
								if (ques.getIsRequired() == 1 && questionType == 1) {
									isRequired = "*" + (i + 1) + "." + ques.getQuestionName() + "[多选题]";
								} else if (qsn.getQuestions().get(i).getIsRequired() == 1) {
									isRequired = "*" + (i + 1) + "." + ques.getQuestionName();
								} else {
									isRequired = " " + (i + 1) + "." + ques.getQuestionName();
								}
						%>
						<div class="quesTitle">
							<%=isRequired%>
						</div>
						<div class="quesOption">

							<ul>

								<%
									if (questionType == 2) {
								%>
								<li>
									<textarea style="border: 1px solid #999;height: 25px; width: 50%;" type="<%=opType%>" name="q<%=(i+1)%>" id="q<%=(i+1) + "_1"%>" ></textarea>
								</li>
								<%
									} else {
											for (int j = 0; j < ques.getOptions().size(); j++) {
												op = ques.getOptions().get(j);
								%>
								<li>
								<input type="<%=opType%>" name="q<%=(i + 1)%>" id="q<%=(i + 1) + "_" + (j + 1)%>" value="<%=op.getId() %>" /> 
								<label for="q<%=(i + 1) + "_" + (j + 1)%>"><%=op.getOptionName()%></label>
								</li>
								<%
									}
										}
								%>
							</ul>
							
						</div>
					</div>
					<%
						}
					%>
					<input style="display:none;" id="qsnId" name="qsnId" type="text" value="<%=qsn.getId() %>">
					<%
						
						if(isExist){
					%>
						<div class="hasSubmit">您已填写过此问卷！ </div>
						<input class="qsnSubmit" type="submit" disabled="disabled" value="提交"/>
					<%
						} else {
					%>
						<input class="qsnSubmit" type="submit" value="提交"/>
					<%
						}
					%>
				</form>
			</div>
		</div>
	</div>
</body>
</html>