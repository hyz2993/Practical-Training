/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.3
 * Generated at: 2019-07-12 02:06:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class regist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>注册</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\ttable{\r\n");
      out.write("\t\tborder-collapse: collapse;\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t}\r\n");
      out.write("\ttable tr td{\r\n");
      out.write("\t\tpadding: 10px 20px;\r\n");
      out.write("\t}\r\n");
      out.write("\th1{\r\n");
      out.write("\t\tcolor: cyan;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div style=\"text-align: center;width: 100%\">\r\n");
      out.write("\t<h1>注册页面</h1>\r\n");
      out.write("\t<div style=\"margin: auto; width: 50%;\">\r\n");
      out.write("\t\t<form action=\"regist.action\" method=\"post\">\r\n");
      out.write("\t\t\t<table border=\"1\">\r\n");
      out.write("\t\t\t\t<tr><td>用户名：</td><td><input name=\"name\" type=\"text\" placeholder=\"请输入您的姓名\"></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td>密码：</td><td><input name=\"pass\" type=\"password\" placeholder=\"请输入您的密码\"></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td>性别：</td><td><input type=\"radio\" name=\"sex\" value=\"男\">男&nbsp;&nbsp;<input name=\"sex\" type=\"radio\" value=\"女\">女</td></tr>\r\n");
      out.write("\t\t\t\t<tr><td>年龄：</td><td><input name=\"age\" type=\"number\" min=\"1\" max=\"150\"></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td>手机电话：</td><td><input name=\"tel\" type=\"number\" min=\"10000000000\" maxlength=\"11\"  placeholder=\"电话\" value=\"18899996666\"></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td>生日：</td><td><input name=\"birthday\" type=\"date\"></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td colspan=\"2\" align=\"center\"><input type=\"submit\" value=\"提交\"><input type=\"reset\" value=\"重置\"></td></tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}