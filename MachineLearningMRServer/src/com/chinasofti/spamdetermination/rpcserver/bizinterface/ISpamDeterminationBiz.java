package com.chinasofti.spamdetermination.rpcserver.bizinterface;

public interface ISpamDeterminationBiz {
	
	/**
	 * 增加消息识别
	 * @param msg 消息
	 * @param isSpam 是不是一个垃圾消息：true是垃圾消息，false反之
	 */
	public void submitMsg(String msg,boolean isSpam);
	/**
	 * 客户端传递字符串
	 * @param msg 字符串
	 * @return 有效消息或者无效消息
	 */
	public boolean isSpam(String msg);
	/**
	 * 重新进行数据清洗
	 */
	public void reMR();
	/**
	 * 得到全局计数器的值
	 */
	public long getGlobalCounterValue(String counterKey);
	/**
	 * 设置全局计数器的值
	 */
	public void setGlobalCounterValue(String counterKey,long counterValue);
	/**
	 * 在现有的全局计数器进行累加
	 */
	public void globalCounterValueIncrement(String counterKey,long counterValue);
}
