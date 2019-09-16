package com.company.server;

import com.company.biz.BizImpl;
import com.company.biz.IBiz;
import com.company.rpc.Service;

/**
 * @author Johnny
 * @category ����ҵ���ʵ�ֶ���
 */
public class BizServer {

	public static void main(String[] args) {
		IBiz biz = new BizImpl();
		Service.bind("HelloBiz", biz);
	}
}
