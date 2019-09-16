package com.company.client;

import com.company.biz.IBiz;
import com.company.rpc.Service;

/**
 * @author Johnny
 * @category ¿Í»§¶Ë
 */
public class BizClient {

	public static void main(String[] args) {
		IBiz biz = (IBiz)Service.lookup("127.0.0.1", "HelloBiz");
		System.out.println(biz.sayHello("lisa"));
	}

}
