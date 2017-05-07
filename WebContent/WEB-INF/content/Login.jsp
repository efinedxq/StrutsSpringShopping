<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="loginPage" /></title>
</head>
<body>
<s:form action="myLoginAction">
   <s:actionerror/>
   ${tip}<br>
   <s:textfield name="username" label="用户名"/>
   <s:password name="password" label="密  码"/>
   <s:submit value="登 录"/>
</s:form>
</body>
</html>