<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${blog.title}</title>
</head>
<body background="img/bg.jpg">
<c:import url="header.jsp"></c:import>
<div align="center" style="width:100%">
	<!-- TITLE --><!-- AUTHOR -->
		<h1>${blog.title}12321</h1>
		<div style="width:70%">
			<span style="left:0;">&nbsp;&nbsp;&nbsp;&nbsp;作者：${blog.uid}</span>
		</div>
	<!-- CONTENT -->
	<div style="width:70%">
		<p style="lead">${blog.content}123</p>
		<span style="text-align:right;">点击量：${blog.click}</span>&nbsp;&nbsp;&nbsp;&nbsp;
		<span style="text-align:right;">发表时间：${blog.datetime}</span>&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
</div>
</body>
</html>