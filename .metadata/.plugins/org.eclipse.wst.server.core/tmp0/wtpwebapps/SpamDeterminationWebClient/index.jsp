<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>

</head>
<body background="img/bg.jpg">
	<c:import url="header.jsp"></c:import>
	<div align="center">
		<h1>welcome into OA system</h1>
		<c:if test="${user == null }">
			<a href="login.jsp">登录</a>&nbsp;&nbsp; 
			<!-- <a href="userlist.action"style="display: none;">进入用户列表</a>&nbsp;&nbsp;  -->
			<a href="register.jsp">进入用户注册</a>
		</c:if>
		<c:if test="${user!= null }">
			<a href="logout.action">退出当前用户</a>
		</c:if>
	</div>
</body>
</html>