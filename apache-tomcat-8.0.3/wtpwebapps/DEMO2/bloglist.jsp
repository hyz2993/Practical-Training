<%@ page language="java" contentType="text/html;charset=gb2312" import = "java.sql.*,java.util.*"%>
<jsp:useBean id="subject" scope="page" class="exam.exam"/>
<html>
<head>
<title>��Ա����</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<%
String id=(String)session.getAttribute("id");
if(id==null)
{
	response.sendRedirect("index.htm");
}
//��ֹ�Ƿ���¼
%>
<style type="text/css">
<!--
a:active,
a:visited,
a:link {
  font-color:black;
  text-decoration:none;
  font-family: "����";
  font-size:20px;
}
.style2 {
	font-family: "����";
	color: #a42a25;
	font-size: 40px;
	text-shadow:5px 2px 6px #000;
}
.style3 {
	font-family: "����";
	color: #a42a25;
	font-size: 20px;
}
.style6 {
	color: black;
}
.style12 {font-size: 16px}

.style14 {
	color: black;
	font-size: 18px;
}
.style15 {color: #a42a25; font-family: "����"}
.style20 {color: #a42a25; font-family: "΢���ź�"; }
.style30 {font-size: 18px; color: #3366FF; font-family: "��Բ";}
.style31 {color: #333333}
.style32 {font-family: "��������"; color: #333333; }
.style35 {color: #336600; font-family: "��Բ";}
.style38 {color: #3366FF; font-family: "��Բ"; font-size: 18px; }
.style39 {font-size: 20px}
.style40 {font-size: 16px; color: #333333;}
-->
</style>
</head>
<SCRIPT LANGUAGE="JavaScript">
function del(vid){
    if (confirm("�����Ҫɾ����?"))
	{
	document.S_form.del.value =vid;
	document.S_form.action="Del";
	document.S_form.submit();
	window.close();
	}	
}
//ɾ����ʾ
</script>
<%
String key=request.getParameter("key");
System.out.println(key);
String sql="select * from userinfo";
System.out.println("sql="+sql);
ResultSet rs=subject.executeQuery(sql);
%>
<body>
<br/><br/>	
<table width="900" border="0" align="center">
   <tr> 
		<td width="200"><img src="images-1/yuanhui.png" height="200"></td>
    	<td width="700" height="54"><p align="center"><span class="style2">��&nbsp;Ա&nbsp;��&nbsp;��</span><br/><br/>
      	<p align="center">    <span class="style15">
      	<img src="images/icon_home.gif" width="16" height="16"><a href="indexapp.jsp" class="style14" >������ҳ</a>
      	<img src="images/female.gif"><a href="admin.jsp" class="style14">���ʹ���</a>
		<img src="images/female.gif"><a href="useradmin.jsp" class=" style14">��Ա����</a>		
		<img src="images/icon_ar.gif"><a href="out.jsp" class="style14">�������</a>
		<img src="images/icon_al.gif"><a href="into.jsp" class="style14">������</a> 
		<img src="images/icon_forum.gif" width="13" height="13"><a href="outoff.jsp" class="style14">�˳�ϵͳ</a>
	</span></td>
  </tr>
</table>
<br/>
<table width="900" border="0" align=center>
	<tr height=20></tr>
    <tr height="30" bgcolor="#cbb87d" class="style4">
    <td ><p align="left" class="style40"><span class="style12">����λ��:��ҳ����Ա�����ɾ����Ϣ</span></p></td>
  </tr>
</table>
<br/>
<form id="S_form" name="S_form" method="get" action="Del?del=" + ID + " method="get">
  <table width="800" border=1 align="center" cellspacing="0">
    <tr bgcolor="#cbb87d"> 
       <td width="200" height="20" > 
      <p align="center" class="style6">��Ա�˺�</p></td>
		<td width="200" height="20" > 
      <p align="center" class="style6">��Աְ��</p></td>
      <td width="200" height="20" > 
      <p align="center" class="style6">ɾ����Ϣ</p></td>
     
</tr>
<%         while(rs.next())
            {
			String ID=rs.getString("ID");
			String userid=rs.getString("userid");
			String userpwd=rs.getString("userpwd");
			String usertitle=rs.getString("usertitle");
%>	
<tr>
<td width="200" height="20" ><p align="center" class="style6"><%=userid%></p></td>
<td width="200" height="20" ><p align="center" class="style6"><%=usertitle%></p></td>
<td width="200" align="center"><span class="style6"><font color="000000"><a href="javascript:del('<%=ID%>')" class="style3">
	<% if(userid.equals(id)){ out.print("ɾ��"); } %>
	</a></font></span></td>
</tr>
<%}%>
</table>
	 <input type="hidden" id="udp" name="udp">
	 <input type="hidden" id="del" name="del">
</form>
<br/>
<p align="center"><font color="#A3B2CC"><img src="images/icon_home.gif" width="16" height="16"><a href="useradmin.jsp" class="style9"><font color="#B0BDD3" face="��������">&lt;&lt;����</font></a></font></p> 
</body>
</html>
