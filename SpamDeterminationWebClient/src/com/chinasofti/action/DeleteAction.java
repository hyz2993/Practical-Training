package com.chinasofti.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.dao.UserDaoImpl;

/**
 * @category 删除的控制器
 */
@WebServlet("/delete.action")
public class DeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0创建dao对象
		UserDaoImpl userDao = new UserDaoImpl();
		//1取得用户的Id
		String idStr = request.getParameter("id");
		int id = Integer.valueOf(idStr);
		//2将用户的id传递给 dao的对象，调用删除方法
		int i = userDao.delete(id);
		//3根据返回结果，响应响应页面
		if(i>0){
			//4成功了跳转到list控制器
			response.sendRedirect("userlist.action");
		}else{
			response.sendRedirect("error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
