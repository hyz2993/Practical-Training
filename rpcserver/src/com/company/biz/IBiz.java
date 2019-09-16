package com.company.biz;


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Johnny
 * @category 服务器的业务逻辑的接口
 */
public interface IBiz {

	public String sayHello(String somebody);
}
