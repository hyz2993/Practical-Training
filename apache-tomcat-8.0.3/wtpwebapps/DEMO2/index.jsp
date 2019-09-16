<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OA system</title>
<style type="text/css">
.qrcodew
{
	width:100px;
	height:120px;
	position:fixed;
 	right:50px;
	bottom:50px;
	transition-property:transform;
	transition-duration:0.5s;
	transition-tining-function:linear;
}
.qrcodew:hover{transform: scale(1.5);}
	.qrcode
	{
		width:200px;
		height:100px;
		position:absolute;
		top:0;
		right:0;
	}
	.qfont
	{
		width:100px;
		height:100px;
		font-size:16px;
		font-family:等线;
		color:#d5133f;
		text-align:center;
	}
</style>
</head>
<body background="img/bg.jpg" >
<c:import url="header.jsp"></c:import>
<div align="center" style="margin-top:200;">
<h1>Welcome into OA system</h1>
<br><br><br>
<a href="login.jsp">登录</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="register.jsp">进入用户注册</a>
</div>
<div class="qrcodew">
	<div class=qrcode><img src="img/qrcode.png" width="100px" alt="QR-Code" ></div>
	<div class=qfont>关注我们</div>
</div>
</body>
</html>