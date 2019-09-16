package rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Johnny
 * �������ľ���ʵ����
 */
public class BizImpl extends UnicastRemoteObject implements IBiz {

	// �÷���������ʾ���ṩ
	protected BizImpl() throws RemoteException {
		super();
	}

	@Override
	public String sayHello(String somebody) throws RemoteException {
		System.out.println("server : Name is " + somebody);
		return "Hello " + somebody;
	}
}