package com.chinasofti.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.dao.UserDaoImpl;
import com.chinasofti.pojo.User;
/**
 * @author WilliamHo
 * @category login controller
 */
@WebServlet("/login.action")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf8");
		
		//数据访问对象
		UserDaoImpl userDao = new UserDaoImpl();
		
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		
		System.out.println(name);
		System.out.println(pw);
		
		User user = userDao.find(name, pw);
		String mess = null;
		if(user != null){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			if(user.getId()==1){
				//admin
				response.sendRedirect("userlist.action");
			}else{
				//users
				request.getRequestDispatcher("userinfo.jsp").forward(request, response);
			}
		}else{
			mess = "用户名或密码错误";
			request.setAttribute("mess",mess);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
