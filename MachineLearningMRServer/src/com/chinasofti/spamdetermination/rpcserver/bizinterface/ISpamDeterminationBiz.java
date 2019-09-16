package com.chinasofti.spamdetermination.rpcserver.bizinterface;

public interface ISpamDeterminationBiz {
	
	/**
	 * ������Ϣʶ��
	 * @param msg ��Ϣ
	 * @param isSpam �ǲ���һ��������Ϣ��true��������Ϣ��false��֮
	 */
	public void submitMsg(String msg,boolean isSpam);
	/**
	 * �ͻ��˴����ַ���
	 * @param msg �ַ���
	 * @return ��Ч��Ϣ������Ч��Ϣ
	 */
	public boolean isSpam(String msg);
	/**
	 * ���½���������ϴ
	 */
	public void reMR();
	/**
	 * �õ�ȫ�ּ�������ֵ
	 */
	public long getGlobalCounterValue(String counterKey);
	/**
	 * ����ȫ�ּ�������ֵ
	 */
	public void setGlobalCounterValue(String counterKey,long counterValue);
	/**
	 * �����е�ȫ�ּ����������ۼ�
	 */
	public void globalCounterValueIncrement(String counterKey,long counterValue);
}
