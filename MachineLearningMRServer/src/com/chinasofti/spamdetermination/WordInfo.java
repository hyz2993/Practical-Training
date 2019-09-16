/**
 */
package com.chinasofti.spamdetermination;

import java.io.*;

/**
 * <p>
 * Title: WordInfo
 * </p>
 * <p>
 * Description:���ڱ���ѧϰ���ݷִʺ��������Ϣ�Ĺ��ߣ������ִʺ�ĵ��ʱ����Լ��õ�������Ч�����г��ֵĴ�������������Ϣ�г��ֵĴ���
 * </p>
 * <p>
 * Copyright: Copyright (c) 2017
 * </p>
 * <p>
 * Company: ChinaSoft International Ltd.
 * </p>
 * 
 * @author etc
 * @version 1.0
 */
public class WordInfo {

	/**
	 * �����ַ���
	 * */
	private String word;
	/**
	 * ����������Ч�����г��ֵĴ���
	 * */
	private int hamNum;
	/**
	 * ��������������Ϣ�г��ֵĴ���
	 * */
	private int spamNum;

	private float wordHamPossibility;

	private float wordSpamPossibility;

	public float getWordHamPossibility() {
		return wordHamPossibility;
	}

	public void setWordHamPossibility(float wordHamPossibility) {
		this.wordHamPossibility = wordHamPossibility;
	}

	public float getWordSpamPossibility() {
		return wordSpamPossibility;
	}

	public void setWordSpamPossibility(float wordSpamPossibility) {
		this.wordSpamPossibility = wordSpamPossibility;
	}

	/**
	 * ��ȡ�����ַ����ķ���
	 * 
	 * @return �����ַ���
	 * */
	public String getWord() {
		// ���ص����ַ���
		return word;
	}

	/**
	 * ���õ����ַ����ķ���
	 * 
	 * @param word
	 *            �ִʻ�ȡ���ĵ����ַ���
	 * */
	public void setWord(String word) {
		// ���õ����ַ���
		this.word = word;
	}

	/**
	 * ��ȡ����������Ч��Ϣ�г��ֵĴ����ķ���
	 * 
	 * @return ����������Ч��Ϣ�г��ֵĴ���
	 * */
	public int getHamNum() {
		// ��ȡ����������Ч��Ϣ�г��ֵĴ���
		return hamNum;
	}

	/**
	 * ���ñ���������Ч��Ϣ�г��ֵĴ����ķ���
	 * 
	 * @param hamNum
	 *            ����������Ч��Ϣ�г��ֵĴ���
	 * */
	public void setHamNum(int hamNum) {
		// ���ñ���������Ч��Ϣ�г��ֵĴ���
		this.hamNum = hamNum;
	}

	/**
	 * ��ȡ��������������Ϣ�г��ֵĴ����ķ���
	 * 
	 * @return hamNum ��������������Ϣ�г��ֵĴ���
	 * */
	public int getSpamNum() {
		// ��ȡ��������������Ϣ�г��ֵĴ���
		return spamNum;
	}

	/**
	 * ���ñ�������������Ϣ�г��ֵĴ����ķ���
	 * 
	 * @param hamNum
	 *            ��������������Ϣ�г��ֵĴ���
	 * */
	public void setSpamNum(int spamNum) {
		// ���ñ�������������Ϣ�г��ֵĴ���
		this.spamNum = spamNum;
	}

	public static  WordInfo getInstanceByByteArray(byte[] data) throws Exception {

		WordInfo word = new WordInfo();
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		DataInputStream dis = new DataInputStream(bais);
		word.setWord(dis.readUTF());
		word.setHamNum(dis.readInt());
		word.setSpamNum(dis.readInt());
		word.setWordHamPossibility(dis.readFloat());
		word.setWordSpamPossibility(dis.readFloat());
		return word;
	}

	public byte[] saveInstanceToBytaArray() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeUTF(word);
		dos.writeInt(hamNum);
		dos.writeInt(spamNum);
		dos.writeFloat(wordHamPossibility);
		dos.writeFloat(wordSpamPossibility);
		byte[] data = baos.toByteArray();
		dos.close();
		baos.close();
		return data;
	}

}
