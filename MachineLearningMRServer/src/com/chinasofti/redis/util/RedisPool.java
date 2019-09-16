package com.chinasofti.redis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import org.apache.commons.pool.impl.*;
import org.apache.zookeeper.server.ServerConfig;

import com.chinasofti.spamdetermination.ServerContext;

public class RedisPool {
	// Redis������IP
	private static String ADDR = ServerContext.REDIS_SERVER;

	// Redis�Ķ˿ں�
	private static int PORT = Integer.parseInt(ServerContext.REDIS_PORT);

	// ��������
	private static String AUTH = ServerContext.REDIS_PASS;

	// ��������ʵ���������Ŀ��Ĭ��ֵΪ8��
	// �����ֵΪ-1�����ʾ�����ƣ����pool�Ѿ�������maxActive��jedisʵ�������ʱpool��״̬Ϊexhausted(�ľ�)��
	private static int MAX_ACTIVE = 1024;

	// ����һ��pool����ж��ٸ�״̬Ϊidle(���е�)��jedisʵ����Ĭ��ֵҲ��8��
	private static int MAX_IDLE = 200;

	// �ȴ��������ӵ����ʱ�䣬��λ���룬Ĭ��ֵΪ-1����ʾ������ʱ����������ȴ�ʱ�䣬��ֱ���׳�JedisConnectionException��
	private static long MAX_WAIT = 10000;

	private static int TIMEOUT = 10000;

	// ��borrowһ��jedisʵ��ʱ���Ƿ���ǰ����validate���������Ϊtrue����õ���jedisʵ�����ǿ��õģ�
	private static boolean TEST_ON_BORROW = true;

	private static JedisPool jedisPool = null;
	private static JedisPoolConfig config = null;

	/**
	 * ��ʼ��Redis���ӳ�
	 */
	static {
		try {
			config = new JedisPoolConfig();

			config.setMaxActive(MAX_ACTIVE);
			config.setMaxIdle(MAX_IDLE);
			config.setMaxWait(MAX_WAIT);
			config.setTestOnBorrow(TEST_ON_BORROW);

			// jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
			// jedisPool = new JedisPoo
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡJedisʵ��
	 * 
	 * @return
	 */
	public synchronized static Jedis getJedis(boolean auth) {
		try {

			if (jedisPool == null) {
				if (auth) {
					jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
				} else {
					jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT);
				}
			}

			Jedis resource = jedisPool.getResource();
			return resource;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * �ͷ�jedis��Դ
	 * 
	 * @param jedis
	 */
	public static void returnResource(final Jedis jedis) {
		if (jedis != null) {
			jedisPool.returnResource(jedis);
		}
	}
}
