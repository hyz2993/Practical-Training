package rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Johnny
 * @category ��������ҵ���߼��Ľӿ�
 */
public interface IBiz extends Remote {

	public String sayHello(String somebody) throws RemoteException;
}
