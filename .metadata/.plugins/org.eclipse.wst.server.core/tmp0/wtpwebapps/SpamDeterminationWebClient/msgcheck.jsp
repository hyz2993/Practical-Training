<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>垃圾消息识别页面</title>
<style type="text/css">
.dd1{
	width: 100%;
	min-height: 400px;
}
.dd2{
	width: 600px;
	margin: 0 auto;
}
</style>
</head>
<body background="img/bg.jpg">
	<c:import url="header.jsp"/>
	<div class="dd1">
		<div class="dd2">
			<form method="post" action="check">
				<h4>输入消息：</h4>
				<p><input class="form-control" type="text" name="msg"></p>
				<p align=center><input class="btn btn-success" type="submit" value="提交查询内容"></p>
			</form>
		</div>
	</div>
</body>
</html>