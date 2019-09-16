package com.chinasofti.spamdetermination.rpcserver.bizimpl;

import java.io.*;
import java.util.UUID;

import redis.clients.jedis.Jedis;

import com.chinasofti.hadoop.hdfs.HDFSOps;
import com.chinasofti.redis.util.RedisPool;
import com.chinasofti.spamdetermination.ServerContext;
import com.chinasofti.spamdetermination.WordInfo;
import com.chinasofti.spamdetermination.rpcserver.bizimpl.mr.GlobalCounters;
import com.chinasofti.spamdetermination.rpcserver.bizimpl.mr.SpamDeteminationMapReduce;
import com.chinasofti.spamdetermination.rpcserver.bizinterface.ISpamDeterminationBiz;

public class SpamDeterminationBizImpl implements ISpamDeterminationBiz {

	long FILE_LENGTH_128M = 1024 * 1024 * 128;//128MB��С��Hadoop2��һ��Ĭ�ϵķֿ��С����128MB
	// HDFSOps hdfs = new HDFSOps("hdfs://192.168.1.119:9000/");
	// Jedis jedis = new Jedis("192.168.1.119");
	Jedis jedis = null;
	SpamDeteminationMapReduce mr = new SpamDeteminationMapReduce();

	@Override
	public void submitMsg(String msg, boolean isSpam) {
		// TODO Auto-generated method stub

		File learningData = new File("leanrningData");
		if (learningData.exists() && learningData.length() > FILE_LENGTH_128M) {
			moveLearningDataToHDFS(learningData);
			reMR();//������ϴ
		}
		try {
			FileOutputStream fos = new FileOutputStream(learningData, true);
			String context = "";
			if (isSpam) {
				context += "spam	";
			} else {
				context += "ham	";
			}
			context += msg;
			System.out.println("����ѧϰ���ݣ�" + context);
			fos.write((context + "\n").getBytes());
			fos.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public boolean isSpam(String msg) {

		jedis = RedisPool.getJedis(false);
		// ��Ŀ���ַ���������Ȼ�ִ�
		String[] words = msg.split(" ");
		// ������Ч���ݵı��ʺ�������Ϣ�ı��ʣ����������Ϣ�ı�������˵����Ϊ������Ϣ����֮��Ϊ��Ч��Ϣ
		boolean result = computeStringSpamResult(words) > computeStringHamResult(words);
		RedisPool.returnResource(jedis);

		return result;
	}

	/**
	 * �����ַ�������Ч��Ϣ�ı��ʽ��
	 * 
	 * @param words
	 *            �������ַ����ķִʽ��
	 * @return �ַ�������Ч��Ϣ�ı��ʽ��
	 * */
	float computeStringHamResult(String[] words) {
		// ����������
		float result = 1.0f;
		// ѭ������Ŀ���ַ����ִʽ��
		for (String word : words) {

			try {
				// ������ʴ�����ѧϰ������
				if (jedis.get(word.getBytes()) != null) {
					// �ۼƳ��ָõ��ʺ���ϢΪ��Ч��Ϣ�ı���

					WordInfo info = WordInfo.getInstanceByByteArray(jedis
							.get(word.getBytes()));
					result *= info.getWordHamPossibility();

				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
		// ���ؼ�����
		return result;

	}

	/**
	 * �����ַ���������Ϣ�ı��ʽ��
	 * 
	 * @param words
	 *            �������ַ����ķִʽ��
	 * @return �ַ�����������Ϣ�ı��ʽ��
	 * */
	float computeStringSpamResult(String[] words) {
		// ����������
		float result = 1.0f;
		// ѭ������Ŀ���ַ����ִʽ��
		for (String word : words) {
			try {
				// ������ʴ�����ѧϰ������
				if (jedis.get(word.getBytes()) != null) {
					// �ۼƳ��ָõ��ʺ���ϢΪ������Ϣ�ı���

					WordInfo info = WordInfo.getInstanceByByteArray(jedis
							.get(word.getBytes()));
					result *= info.getWordSpamPossibility();

				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		// ���ؼ�����
		return result;

	}

	@Override
	public void reMR() {
		try {
			mr.beginMR();//���������������
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void moveLearningDataToHDFS(File file) {
		String localPath = file.getAbsolutePath();
		String uuid = UUID.randomUUID().toString();

		try {
			HDFSOps hdfs = new HDFSOps(ServerContext.HDFS_ROOT);
			hdfs.uploadFile(localPath, "/spamdetermination/learningdata/"
					+ uuid + ".txt");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public long getGlobalCounterValue(String counterKey) {
		// TODO Auto-generated method stub
		return GlobalCounters.getCounterValue(counterKey);
	}

	@Override
	public void setGlobalCounterValue(String counterKey, long counterValue) {
		GlobalCounters.setCounterValue(counterKey, counterValue);

	}

	@Override
	public void globalCounterValueIncrement(String counterKey, long counterValue) {
		GlobalCounters.increment(counterKey, counterValue);

	}

	public static void main(String[] args) throws Exception {
		SpamDeterminationBizImpl biz = new SpamDeterminationBizImpl();
		// System.out.println(biz.isSpam("Hello us"));
		biz.reMR();

	}

}
