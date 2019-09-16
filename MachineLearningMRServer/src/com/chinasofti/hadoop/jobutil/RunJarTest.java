package com.chinasofti.hadoop.jobutil;



public class RunJarTest {

	/**
	 * @param args
	 * @throws Throwable
	 */
	public static void main(String[] args) throws Throwable {
		args = new String[4];
		args[0] = "E:/hadoop-2.6.4/share/hadoop/mapreduce/hadoop-mapreduce-examples-2.6.4.jar";
		args[1] = "pi";
		args[2] = "2";
		args[3] = "100";

		EJob.addDefaultClasspath("E:/hadoop-2.6.4");
		EJob.runJar(args);
	}

}
