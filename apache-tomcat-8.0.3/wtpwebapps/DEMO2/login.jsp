<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<style type="text/css">
h1{
	color: white;
}
.inputtext{
	padding: 5px;
}
.mess{
	color: red;
}
</style>
</head>
<body background="img/bg.jpg">
<c:import url="header.jsp"></c:import>
<div align=center style="text-align:center; margin-top:200;">
<h1>登录</h1>
<form action="login.action" method="post">
	<p>用户名：<input type="text" name="name" class="inputtext" placeholder="请输入您的名字"></p>
	<p>密&nbsp;&nbsp;码：<input name="pw" class="inputtext" type="password" /></p>
	<p><input type="submit" value="提交">
		<input type="reset" value="重置">
		<a href="register.jsp">注册</a>	
	</p>
	<p class="mess">${mess }</p>
</form>
</div>
</body>
</html>