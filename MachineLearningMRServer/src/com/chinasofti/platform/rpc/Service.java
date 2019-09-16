/**
 *  Copyright 2017 ChinaSoft International Ltd. All rights reserved.
 */
package com.chinasofti.platform.rpc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

/**
 * <p>
 * Title: Service
 * </p>
 * <p>
 * Description: �Զ��������RPC��Զ�̷���������ʽ���ĺ��ķ�����
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
public class Service {

	/**
	 * �ṩԶ�̷����TCP Socket������
	 * */
	public static ServerSocket server;
	/**
	 * Զ�̷������÷���Ķ˿ں�
	 * */
	private static int servicePort = 1689;

	/**
	 * �޸ķ���Ķ˿ڵķ���
	 * 
	 * @param port
	 *            ϣ��ʹ�õ�Ŀ��˿ں�
	 * */
	public static void setPort(int port) {
		// �������û�����������޸Ķ˿ں�
		if (server == null) {
			// �޸Ķ˿ں�
			servicePort = port;
		}
	}

	/**
	 * �������˰󶨵ķ�������б�
	 * */
	private static Hashtable<String,Object> bindservice = new Hashtable<String,Object>();

	/**
	 * ע��󶨷������ķ���
	 * 
	 * @param bindName
	 *            ��������ڷ������ϵİ������ͻ���ͨ���ð����Ƽ������������
	 * @param bindObject
	 *            �󶨵��������ϵķ������
	 * */
	public static void bind(String bindName, Object bindObject) {
		// �������������δ����
		if (server == null) {
			// ��������������
			try {
				// ����������Socket����
				server = new ServerSocket(servicePort);
				// ����������Socket���ӷ����߳�
				ConnectThread ct = new ConnectThread(server);
				// ����������Socket���ӷ����߳�
				ct.start();
				// ������������������е��쳣
			} catch (Exception ex) {
				// ��������쳣���������쳣��Ϣ
				ex.printStackTrace();
			}
		}
		// ��������������ṩ�ķ������󶨵���������
		bindservice.put(bindName, bindObject);

	}

	/**
	 * ��ȡ�������������ʵ�ֵ�ҵ��ӿ����ķ������ṩ���ͻ��˽��д���
	 * 
	 * @param bindName
	 *            ��������ڷ������ϵİ������ͻ���ͨ���ð����Ƽ�����������󲢻�ȡ�ö���������ʵ�ֵ�ҵ��ӿ�
	 * */
	public static String getBindObjectInterface(String bindName) {
		// ���Ի�ȡ�ӿ�������
		try {
			// ��ȡ���������������˵��
			Class<?> nowClass = bindservice.get(bindName).getClass();
			// �����ӿ�˵������
			Class<?> interfaceClass = null;
			// ��ѭ����ʽ���ϲ���ҵ��ӿڣ���ʵ����ҵ��ӿ�ֻ����һ��,�����νṹ������������ӿ�Ϊ׼�����ҵ����Ҫ����ӿڣ����Դ���һ���м�ͳһ��ҵ��ӿڣ������ҵ��ӿڼ̳���Ҫʵ�ֵĽӿ��б�
			while (nowClass.getSuperclass() != null && interfaceClass == null) {
				// �ж���ǰ���Ƿ�ʵ���˽ӿ�
				if (nowClass.getInterfaces().length > 0) {
					// ���ʵ���˽ӿ��򽫸ýӿ�����ҵ��ӿ�
					interfaceClass = nowClass.getInterfaces()[0];
					// �Ѿ����ҵ���Ҫ�Ľӿڣ�������ѭ��
					break;
				}
				// ���û���ҵ��ӿڣ����������ṹ�ĸ�������
				nowClass = nowClass.getSuperclass();
			}
			// ���ؽӿ�ȫ�޶�����
			return interfaceClass.getCanonicalName();
			// ����ֱ�й����е��쳣
		} catch (Exception ex) {
			// ��������쳣������򷵻ؿհ׵Ľӿ���
			return "";
		}
	}

	/**
	 * ִ�з�����Զ�̷���
	 * 
	 * @param bindName
	 *            ��������ڷ������ϵİ������ͻ���ͨ���ð����Ƽ������������
	 * @param methodName
	 *            ϣ���ڷ������ϵ��õ�Զ�̷�����
	 * @param argtypes
	 *            ϣ���ڷ������ϵ��õ�Զ�̷��������б�
	 * @param args
	 *            �ͻ��˵��÷���ʱ���ݵ�ʵ���б�
	 * */
	public static Object getInvokeReturn(String bindName, String methodName,
			Class<?>[] argtypes, Object[] args) {
		
	//	System.out.println(bindName+"    "+"    "+methodName+"      "+args[0]);
		
		// �����ڷ������϶�̬����Զ�̷���
		try {
			// �ڷ������ϼ����������
			Object obj = bindservice.get(bindName);
			// ͨ���������Ͳ��������б�̬��ȡ����
			Method method = obj.getClass().getMethod(methodName, argtypes);
			// ��̬���÷�������ȡ����ֵ
			Object returnObj = method.invoke(obj, args);
			// ���ض�̬����ִ�еĽ��
			return returnObj;
			// ����̬���ù����е��쳣
		} catch (Exception ex) {
			// ����쳣��Ϣ
			ex.printStackTrace();
			// ��������쳣���򷵻�null���
			return null;
		}

	}



	/**
	 * �ͻ��˼�����ȡԶ�̷���������ķ������Ƽ�ʹ�ñ��������Զ�ƥ��ҵ��ӿ�
	 * 
	 * @param servername
	 *            ������������IP
	 * @param bindName
	 *            �������İ���
	 * @exception ServiceNotFoundException
	 *                ��������ʧ���׳����쳣��˵����������ַ�������������
	 * */
	public static Object lookup(String servername, String bindName) {
		// ����ͨ��������ѯ����ȡ������Ӧ�������ʵ�ֵ�ҵ��ӿ��������ڴ����ͻ��˱��ش���
		try {
			// ����һ��Socket�������ڷ���ӿ�����ѯ
			Socket client = new Socket(InetAddress.getByName(servername),
					servicePort);
			// �����������ݽ����������
			DataOutputStream dos = new DataOutputStream(
					client.getOutputStream());
			// �����������ݽ�����������
			DataInputStream dis = new DataInputStream(client.getInputStream());
			// ������ѯ����ָ��
			dos.writeInt(ServiceFlag.SERVICE_GETINTERFACE);
			// ������ѯ��Ҫ�İ�������
			dos.writeUTF(bindName);
			// ��ȡ������ͨѶָ��˴������壬���ԣ�������ͨѶЭ�飬����ִ�ж�ȡ������
			dis.readInt();
			// ��ȡ���������صĽӿ�����
			String interfaceName = dis.readUTF();
			// System.out.println(interfaceName+"---------");
			// ����ҵ��ӿ�
			Class<?> interfaceClass = Class.forName(interfaceName);
			// ��ȡԶ��ҵ�������󱾵ش���
			ServiceHandler handler = new ServiceHandler(servicePort, bindName,
					servername);
			// �������ش���
			Object proxyObj = Proxy.newProxyInstance(
					interfaceClass.getClassLoader(),
					new Class[] { interfaceClass }, handler);
			// �������ش���
			return proxyObj;
			// ���񴴽����ش�������е��쳣��Ϣ
		} catch (Exception ex) {
			// ����쳣��Ϣ
			ex.printStackTrace();
			// �����쳣���׳������޷�����������ҵ���쳣��Ӧ�ü������Ƿ���ȷ�ṩ
			throw new ServiceNotFoundException();
			// ex.printStackTrace();
			// return null;
		}
	}
}
