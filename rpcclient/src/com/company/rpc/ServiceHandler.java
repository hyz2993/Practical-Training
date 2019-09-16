/**
 *  Copyright 2017 ChinaSoft International Ltd. All rights reserved.
 */
package com.company.rpc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;

/**
 * <p>
 * Title: ServiceHandler
 * </p>
 * <p>
 * Description: Զ�̷������ô�������
 * </p>
 * <p>
 * Copyright: Copyright (c) 2017
 * </p>
 * <p>
 * Company: ChinaSoft International Ltd.
 * </p>
 * 
 * @author BigData Training
 * @version 0.9
 */
public class ServiceHandler implements InvocationHandler {

	/**
	 * ����������˿�
	 * */
	int port;
	/**
	 * �������
	 * */
	String bindName;
	/**
	 * ��������ַ
	 * */
	String serverName;

	/**
	 * ������������һ���ͻ��˱��ش�������
	 * 
	 * @param port
	 *            �������˿�
	 * @param bindName
	 *            �������
	 * @param serverName
	 *            ��������ַ
	 * */
	public ServiceHandler(int port, String bindName, String serverName) {
		// TODO Auto-generated constructor stub
		// ��ʼ���˿ں�
		this.port = port;
		// ��ʼ������
		this.bindName = bindName;
		// ��ʼ����������ַ
		this.serverName = serverName;
	}

	/**
	 * Զ�̷������ñ��ش����������������磬��ѯԶ�̷�����ִ̬�н����
	 * */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		// ���ӷ�����
		Socket client = new Socket(InetAddress.getByName(serverName), port);
		// �������ݽ��������
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		// �����ѯԶ��ҵ�񷽷�ִ�н������ѯָ��
		dos.writeInt(ServiceFlag.SERVICE_GETINVOKERETURN);
		// ���������ҵ�����������
		dos.writeUTF(bindName);
		// �����ִ�еķ�����
		dos.writeUTF(method.getName());
		// ����������������������ҵ�񷽷����������б��ʵ���б�
		ObjectOutputStream oos = new ObjectOutputStream(
				client.getOutputStream());
		// ������������б�
		oos.writeObject(method.getParameterTypes());
		// ���ʵ���б�
		oos.writeObject(args);
		// ��ȡ���ݽ���������
		DataInputStream dis = new DataInputStream(client.getInputStream());
		// ��ȡ���ָ����ã�������
		dis.readInt();
		// ��ȡ���������������ڶ�ȡԶ�̶�ִ�н��
		ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
		// ��ȡ���
		Object obj = ois.readObject();
		// ���ؽ��
		return obj;
	}

}
