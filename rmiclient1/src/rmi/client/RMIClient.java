package rmi.client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import rmi.server.IBiz;

public class RMIClient {

	public static void main(String[] args) {
		try {
			//服务器所在的ip地址，端口号，服务对象（识别名）
			IBiz biz = (IBiz)java.rmi.Naming.lookup("rmi://127.0.0.1:9999/Hello");
			System.out.println(biz.sayHello("Tom"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

}
