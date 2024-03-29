<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<style type="text/css">
table {
	border-collapse: collapse;
	width: 100%;
}

table tr td {
	padding: 10px 20px;
}

h1 {
	color: cyan;
}
</style>
</head>
<body background="img/bg.jpg">
	<c:import url="header.jsp"></c:import>

	<div style="text-align: center; width: 100%">
		<h1>注册页面</h1>
		<div style="margin: auto; width: 50%;">
			<form action="register.action" method="post">
				<table class="table table-bordered">
					<tr>
						<td>用户名：</td>
						<td><input class="form-control" name="name" type="text"
							placeholder="请输入您的姓名"></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input class="form-control" name="pw" type="password"
							placeholder="请输入您的密码"></td>
					</tr>
					<tr>
						<td>性别：</td>
						<td><input type="radio" name="sex" value="男">男&nbsp;&nbsp;<input
							name="sex" type="radio" value="女">女</td>
					</tr>
					<tr>
						<td>年龄：</td>
						<td><input class="form-control" name="age" type="number"
							min="1" max="150"></td>
					</tr>
					<tr>
						<td>手机电话：</td>
						<td><input class="form-control" name="tel" type="number"
							min="10000000000" maxlength="11" placeholder="电话"
							value="18899996666"></td>
					</tr>
					<tr>
						<td>生日：</td>
						<td><input class="form-control" name="birthday" type="date"></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input class="btn btn-success"
							type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;<input
							class="btn btn-info" type="reset" value="重置"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>