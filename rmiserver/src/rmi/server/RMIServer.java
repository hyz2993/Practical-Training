package rmi.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.security.Provider.Service;

/**
 * @author Johnny
 * @category 构建业务的实现对象
 */
public class RMIServer {

	public static void main(String[] args) {
		try {
			IBiz biz = new BizImpl();//创建业务的实现对象
			//在本地里面构建了一个注册器,表示当前的服务通过哪个端口向外提供服务
			java.rmi.registry.LocateRegistry.createRegistry(9999);
			//把我们的业务对象注册到服务器当中去
			java.rmi.Naming.bind("rmi://127.0.0.1:9999/Hello", biz);
		} catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}
