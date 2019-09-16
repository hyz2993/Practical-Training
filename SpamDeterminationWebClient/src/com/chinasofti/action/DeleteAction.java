package com.chinasofti.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.dao.UserDaoImpl;

/**
 * @category ɾ���Ŀ�����
 */
@WebServlet("/delete.action")
public class DeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0����dao����
		UserDaoImpl userDao = new UserDaoImpl();
		//1ȡ���û���Id
		String idStr = request.getParameter("id");
		int id = Integer.valueOf(idStr);
		//2���û���id���ݸ� dao�Ķ��󣬵���ɾ������
		int i = userDao.delete(id);
		//3���ݷ��ؽ������Ӧ��Ӧҳ��
		if(i>0){
			//4�ɹ�����ת��list������
			response.sendRedirect("userlist.action");
		}else{
			response.sendRedirect("error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
