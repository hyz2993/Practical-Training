package com.company.biz;

/**
 * @author Johnny
 * �������ľ���ʵ����
 */
public class BizImpl implements IBiz {

	@Override
	public String sayHello(String somebody){
		System.out.println("server : Name is " + somebody);
		return "Hello " + somebody;
	}

}
