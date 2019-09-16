package rmi.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.security.Provider.Service;

/**
 * @author Johnny
 * @category ����ҵ���ʵ�ֶ���
 */
public class RMIServer {

	public static void main(String[] args) {
		try {
			IBiz biz = new BizImpl();//����ҵ���ʵ�ֶ���
			//�ڱ������湹����һ��ע����,��ʾ��ǰ�ķ���ͨ���ĸ��˿������ṩ����
			java.rmi.registry.LocateRegistry.createRegistry(9999);
			//�����ǵ�ҵ�����ע�ᵽ����������ȥ
			java.rmi.Naming.bind("rmi://127.0.0.1:9999/Hello", biz);
		} catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}
