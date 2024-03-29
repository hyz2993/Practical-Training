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
@WebServlet("/logout.action")
public class LogoutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LogoutAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.removeAttribute("user");
		request.removeAttribute("uid");
		request.getSession().invalidate();
		response.sendRedirect("index.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
