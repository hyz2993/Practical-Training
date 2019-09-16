/**
 *  Copyright 2017 ChinaSoft International Ltd. All rights reserved.
 */
package com.company.rpc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * <p>
 * Title: ServiceThread
 * </p>
 * <p>
 * Description: �������˷�������������ͻ��˵����ֲ�ͬ������ѯ��ҵ��ӿ�����ѯ��ҵ�񷽷���ִ̬�н����ѯ��
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
public class ServiceThread implements Runnable {
	/**
	 * ��������ͻ��˵�������Ϣ
	 */
	Socket client;

	/**
	 * �������������������˴�����
	 * 
	 * @param client
	 *            ��������ͻ��˵�������Ϣ
	 */
	public ServiceThread(Socket client) {
		// ��ʼ����������ͻ��˵�������Ϣ
		this.client = client;
	}

	/**
	 * �ͻ�����ѯ����ָ��
	 */
	public void run() {
		// �����������
		String bindName = "";
		// ���Ի�ȡ��ѯ�����ؽ��
		try {
			// �������ݽ���������
			DataInputStream dis = new DataInputStream(client.getInputStream());
			// �������ݽ��������
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			// ��ȡ��ѯָ��
			int command = dis.readInt();
			// �ֱ���ѯָ������
			switch (command) {
			// �����ҵ��ӿ�����ѯ
			case ServiceFlag.SERVICE_GETINTERFACE:
				// ��ȡ����
				bindName = dis.readUTF();
				// д��ӿ���ѯ���ָ�����
				dos.writeInt(ServiceFlag.SERVICE_GETINTERFACE);
				// ��ȡ�ӿ�����ͨ�����緵�ظ��ͻ���
				dos.writeUTF(Service.getBindObjectInterface(bindName));
				// ִ�н���
				break;
			// �����Զ��ҵ�񷽷�ִ�н����ѯ
			case ServiceFlag.SERVICE_GETINVOKERETURN:
				// ��ȡ����
				bindName = dis.readUTF();
				// ��ȡ�����õ�Զ��ҵ�񷽷���
				String methodName = dis.readUTF();
				// ��������������
				ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
				// ��ȡ���������б�
				Class<?>[] argtypes = (Class[]) ois.readObject();
				// ��ȡʵ���б�
				Object[] args = (Object[]) ois.readObject();
				// ��̬����ҵ�񷽷�����ȡ���
				Object obj = Service.getInvokeReturn(bindName, methodName, argtypes, args);
				// ���������
				dos = new DataOutputStream(client.getOutputStream());
				// ���ҵ�񷽷�ִ�н��ָ�����
				dos.writeInt(ServiceFlag.SERVICE_GETINVOKERETURN);
				// �������������
				ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
				// ��ͻ������Զ�̷���ִ�еĽ��
				oos.writeObject(obj);
				// ֱ�н���
				break;
			}
			// ���Բ���ִ�й����е��쳣
		} catch (Exception ex) {
			// ����쳣��Ϣ
			ex.printStackTrace();
		}
	}
}
