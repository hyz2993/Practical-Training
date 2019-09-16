package com.company.server;

import com.company.biz.BizImpl;
import com.company.biz.IBiz;
import com.company.rpc.Service;

/**
 * @author Johnny
 * @category 构建业务的实现对象
 */
public class BizServer {

	public static void main(String[] args) {
		IBiz biz = new BizImpl();
		Service.bind("HelloBiz", biz);
	}
}
