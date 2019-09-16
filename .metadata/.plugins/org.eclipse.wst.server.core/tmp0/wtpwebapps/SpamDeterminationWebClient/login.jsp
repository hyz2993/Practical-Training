<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<style type="text/css">
.mess {
	color: red;
}

.form1 {
	width: 600px;
}
</style>
</head>
<body background="img/bg.jpg">
	<c:import url="header.jsp"></c:import>
	<div style="width:100%">
		<div style="margin:auto; width: 600px;">
			<h1>登录</h1>
			<form class="form1" action="login.action" method="post">
				<p>
					用户名：<input class="form-control" type="text" name="name"
						class="inputtext" placeholder="请输入您的名字">
				</p>
				<p>
					密&nbsp;&nbsp;码：<input class="form-control" name="pw"
						class="inputtext" type="password" />
				</p>
				<p>
					<input class="btn btn-success" type="submit" value="提交">
					<input class="btn btn-info" type="reset" value="重置"> <a href="register.jsp">注册</a>
				</p>
				<p class="mess">${mess }</p>
			</form>
		</div>
	</div>
</body>
</html>