<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
table
  {
  border-collapse:collapse;
  }

table, td, th
  {

  }
</style>
</head>
<body>
<c:import url="header.jsp"></c:import>
<div class="main">
  
  <div class="clr"></div>
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
        <div class="article">
          <h2><span>标题：<td>${u.title }</span></h2>
          <div class="clr"></div>
          <p>Posted on 18. Sep, 2015 by Sara in Filed under templates, internet,  with  Comments 18</p>
          <img src="images/img_1.jpg" width="613" height="193" alt="image" />
          <div class="clr"></div>
        <table border="0">

           <tr>
            <td>文章部分 <a href="" title="1">zhaiyao</a></td><td>${u.title }</td>
             </tr>
             <tr>
             
             </tr>
              <tr>
             
             </tr>
           <tr>
            <td>点击量：${u.title }</td><td></td>
             <td>访问量：${u.title }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td></td>
             <td>量：${u.title }</td>
           </tr>
        </table>
        </div>
        <div class="article">
           <h2><span>标题：<td>${u.title }</span></h2>
          <div class="clr"></div>
          <p>Posted on 18. Sep, 2015 by Sara in Filed under templates, internet,  with  Comments 18</p>
          <img src="images/img_1.jpg" width="613" height="193" alt="image" />
          <div class="clr"></div>
        <table border="0">
           <tr>
            <td>文章部分 <a href="" title="1">zhaiyao</a></td><td>${u.title }</td>
             </tr>
             <tr>
             
             </tr>
              <tr>
             
             </tr>
           <tr>
            <td>点击量：${u.title }</td><td></td>
             <td>访问量：${u.title }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td></td>
             <td>量：${u.title }</td>
           </tr>
        </table>
        </div>
        <div class="article" style="padding:5px 20px 2px 20px; background:none; border:0;">
          <p>Page 1 of 2 <span class="butons"><a href="#">3</a><a href="#">2</a> <a href="#" class="active">1</a></span></p>
        </div>
      </div>
      <div class="sidebar">
        <div class="gadget">
          <h2>Sidebar Menu</h2>
          <div class="clr"></div>
          <ul class="sb_menu">
            <li><a href="#">Home</a></li>
            <li><a href="#">TemplateInfo</a></li>
            <li><a href="#">Style Demo</a></li>
            <li><a href="#">Blog</a></li>
            <li><a href="#">Archives</a></li>
            <li><a href="#" title="Website Templates">Web Templates</a></li>
          </ul>
        </div>
        <div class="gadget">
          <h2><span>Sponsors</span></h2>
          <div class="clr"></div>
          <ul class="ex_menu">
            <li><a href="#" title="Website Templates">DreamTemplate</a><br />
              Over 6,000+ Premium Web Templates</li>
            <li><a href="#" title="WordPress Themes">TemplateSOLD</a><br />
              Premium WordPress &amp; Joomla Themes</li>
            <li><a href="#" title="Affordable Hosting">ImHosted.com</a><br />
              Affordable Web Hosting Provider</li>
            <li><a href="#" title="Stock Icons">MyVectorStore</a><br />
              Royalty Free Stock Icons</li>
            <li><a href="#" title="Website Builder">Evrsoft</a><br />
              Website Builder Software &amp; Tools</li>
            <li><a href="#" title="CSS Templates">CSS Hub</a><br />
              Premium CSS Templates</li>
          </ul>
        </div>
        <div class="gadget">
          <h2>Wise Words</h2>
          <div class="clr"></div>
          <p>   <img src="images/test_1.gif" alt="image" width="18" height="17" /> <em>We can let circumstances rule us, or we can take charge and rule our lives from within </em>.<img src="images/test_2.gif" alt="image" width="18" height="17" /></p>
          <p style="float:right;"><strong>Earl Nightingale</strong></p>
          </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  
  <div class="fbg">
    <div class="fbg_resize">
      <div class="col c1">
        <h2><span>这块应该是logo吧</span></h2>
        <a href="#"> <a href="#"><img src="a.png" width="158" height="58" alt="pix" /> <a href="#"> </div>
      <div class="col c2">
        <h2><span>第四组博客</span></h2>
        <p>这是一个假的博客<br />
          我们组超努力的！！！</p>
      </div>
      <div class="col c3">
        <h2><span>关于我们</span></h2>
        <p>第四组是一个优秀的组啊啊，真的很优秀，优秀就是我们，哈哈哈哈哈。我编不出来了<a href="#">666@example.com</a><br />
          <a href="#">110-120-119-111111</a></p>
      </div>
      <div class="clr"></div>
    </div>
    
    <div class="footer">
      <div class="clr"></div>
    </div>
  </div>
</div>
</body>
	
</body>
</html>