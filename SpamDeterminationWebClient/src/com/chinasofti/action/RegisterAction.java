package com.chinasofti.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.dao.UserDaoImpl;
import com.chinasofti.pojo.User;

/**
 * @category 注册的控制器
 */
@WebServlet("/register.action")
public class RegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		// 设置编码集
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		UserDaoImpl dao = new UserDaoImpl();
		// 接受用户的参数
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String sex = request.getParameter("sex");
		String ageStr = request.getParameter("age");
		String tel = request.getParameter("tel");
		String birthdayStr = request.getParameter("birthday");
		int age = Integer.valueOf(ageStr);
		Date birthday = null;
		try {
			birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthdayStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 将用户的参数放入到一个用户对象中
		User user = new User(name, pw, sex, birthday, age, tel, new Date(), request.getRemoteAddr());
		// 将用户对象传入到数据库中，进行持久化操作
		int i = dao.saveInfo(user);
		System.err.println(i > 0 ? "保存成功" : "保存失败");
		// 跳转到登录页面
		response.sendRedirect("userlist.action");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);// 委托
	}
}