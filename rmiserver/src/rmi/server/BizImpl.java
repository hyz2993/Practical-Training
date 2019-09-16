package rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Johnny
 * 服务器的具体实现类
 */
public class BizImpl extends UnicastRemoteObject implements IBiz {

	// 该方法必须显示的提供
	protected BizImpl() throws RemoteException {
		super();
	}

	@Override
	public String sayHello(String somebody) throws RemoteException {
		System.out.println("server : Name is " + somebody);
		return "Hello " + somebody;
	}
}