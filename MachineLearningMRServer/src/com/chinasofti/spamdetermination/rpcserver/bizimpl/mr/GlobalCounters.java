package com.chinasofti.spamdetermination.rpcserver.bizimpl.mr;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GlobalCounters {
	private static Map<String, Counter> Counters;
	static {
		Counters = Collections.synchronizedMap(new HashMap<String, Counter>());

	}

	public static void setCounterValue(String counterKey, long value) {
		if (!Counters.containsKey(counterKey)) {//如果全局计数器没有，则创建一个计数器，放入进去
			Counter counter = new Counter();
			Counters.put(counterKey, counter);
		}
		Counters.get(counterKey).setValue(value);
	}

	public static long getCounterValue(String counterKey) {
		if (!Counters.containsKey(counterKey)) {
			
			//System.out.println("没有这个KEY");
			return 0;
		}
		return Counters.get(counterKey).getValue();
	}
	
	public static void increment(String counterKey, long value){
		if (!Counters.containsKey(counterKey)) {
			Counter counter = new Counter();
			Counters.put(counterKey, counter);
		}
		Counters.get(counterKey).increment(value);
		//System.out.println(Counters.get(counterKey).getValue());
	}

}
