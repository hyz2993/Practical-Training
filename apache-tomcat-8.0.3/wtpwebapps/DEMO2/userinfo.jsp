<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户详情界面</title>
</head>
<body background="img/bg.jpg">
<c:import url="header.jsp"></c:import>
<div  align=center style="text-align:center;width:100%">
	<h1>用户详情</h1>
	<div style="margin:auto;width:80%;">
			<table border=1 class="table table-hover">
				<tr><td>用户名：</td><td>${user.name}</td></tr>
				<tr><td>密码：</td><td>${user.pw}</td></tr>
				<tr><td>性别：</td><td>${user.sex}</td></tr>
				<tr><td>年龄：</td><td>${user.age}</td></tr>
				<tr><td>联系方式：</td><td>${user.tel}</td></tr>
				<tr><td colspan="2" align="center">
						<button onclick="javascript:history.back(-1)">返回</button>
				</td></tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>