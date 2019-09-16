package com.company.biz;

/**
 * @author Johnny
 * 服务器的具体实现类
 */
public class BizImpl implements IBiz {

	@Override
	public String sayHello(String somebody){
		System.out.println("server : Name is " + somebody);
		return "Hello " + somebody;
	}

}
