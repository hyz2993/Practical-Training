/**
 *  Copyright 2017 ChinaSoft International Ltd. All rights reserved.
 */
package com.company.rpc;

/**
 * <p>
 * Title: ServiceNotFoundException
 * </p>
 * <p>
 * Description: Զ�̷����޷��������������쳣����
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
public class ServiceNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6482029944969529522L;

	// ������
	public ServiceNotFoundException() {
		// TODO Auto-generated constructor stub
		// �����޷�������������Ĵ�����ʾ
		super("�����ҵķ����޷��ҵ���");
	}
}
