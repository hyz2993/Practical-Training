<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
.s1{
	color: red;
}
.s2{
	color: green;
}
</style>
</head>
<body background="img/bg.jpg">
	<c:import url="header.jsp" />
	<div align=center>
			<table style="width:80%;" class="table table-striped table-hover">
				<tr>
					<th style="width:70%;text-align:center;">消息</th>
					<th style="width:30%;text-align:center;">属性</th>
				</tr>
				<tr>
					<td>${msg}</td>
					<td style="text-align:center;">
				<c:if test="${flag}">
						<span class="s1">${result}✖</span>
				</c:if>
				<c:if test="${!flag}">
						<span class="s2">${result}✔</span>
				</c:if>
					</td>
				</tr>
			</table>
	</div>
</body>
</html>