/**
 *  Copyright 2017 ChinaSoft International Ltd. All rights reserved.
 */
package com.company.rpc;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * <p>
 * Title: ConnectThread
 * </p>
 * <p>
 * Description: ����һ���µ��߳����ڲ���ͻ��˵�������������
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
public class ConnectThread extends Thread {
	/**
	 * ��������Socket������
	 * */
	ServerSocket server;
	/**
	 * �����̳߳ص�����������ִ�пͻ��˵���ѯ��������ѯ�ӿ�������ѯԶ�̷������ý����
	 * */
	Executor exec = new ScheduledThreadPoolExecutor(50);

	/**
	 * �����������������ŷ��߳�
	 * 
	 * @param server
	 *            ����������
	 * */
	public ConnectThread(ServerSocket server) {
		// ��ʼ��������Socket��������
		this.server = server;
	}

	/**
	 * �߳����񣨲���ӵ����Socket���Ӳ�����
	 * */
	public void run() {
		// ѭ������ͻ�������
		while (true) {
			// ���Բ���ͻ�������
			try {
				// ��ȡ�û���������
				Socket client = server.accept();
				// ��������ͻ�����ѯ������runnable����
				ServiceThread st = new ServiceThread(client);
				// �����̳߳ش���ÿ���û�����
				exec.execute(st);
				// ����ͨѶ�����е��쳣
			} catch (Exception ex) {
				// ����쳣��Ϣ
				ex.printStackTrace();
			}
		}
	}
}
