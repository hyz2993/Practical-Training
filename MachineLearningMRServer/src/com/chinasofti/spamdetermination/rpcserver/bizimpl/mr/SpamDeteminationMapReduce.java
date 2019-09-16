package com.chinasofti.spamdetermination.rpcserver.bizimpl.mr;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import redis.clients.jedis.Jedis;

import com.chinasofti.hadoop.hdfs.HDFSOps;
import com.chinasofti.platform.rpc.Service;
import com.chinasofti.redis.util.RedisPool;
import com.chinasofti.spamdetermination.ServerContext;
import com.chinasofti.spamdetermination.WordInfo;
import com.chinasofti.spamdetermination.rpcserver.bizinterface.ISpamDeterminationBiz;

public class SpamDeteminationMapReduce {

	public void beginMR() throws Exception {
		//�����ͻ��˶���
		ISpamDeterminationBiz biz = (ISpamDeterminationBiz) Service.lookup(
				ServerContext.COUNTER_SERVER, "service");
		biz.setGlobalCounterValue("CounterSpam", 0);
		biz.setGlobalCounterValue("CounterHam", 0);
		Configuration conf = new Configuration();
		String[] otherArgs = new GenericOptionsParser(conf, new String[] {
				ServerContext.HDFS_ROOT+"spamdetermination/learningdata",
				ServerContext.HDFS_ROOT+"spamdetermination/output" })
				.getRemainingArgs();

		Job job = Job.getInstance(conf, "wc");

		// Job job = new Job(conf, "word count");
		job.setJarByClass(SpamDeteminationMapReduce.class);
		job.setMapperClass(SpamDeteminationLearningDataMapper.class);
		// job.setCombinerClass(SpamDeteminationLearningDataReducer.class);

		job.setReducerClass(SpamDeteminationLearningDataReducer.class);
		job.setOutputKeyClass(Text.class);

		job.setOutputValueClass(Text.class);
		FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
		// job.setNumReduceTasks(2);
		// job.setPartitionerClass(SpamDeteminationLearningDataPartitioner.class);
		job.waitForCompletion(true);
		HDFSOps hdfs = new HDFSOps(ServerContext.HDFS_ROOT);
		hdfs.deleteFile("/spamdetermination/output");
	}

	// static Jedis jedis1 = new Jedis("192.168.1.119");
	public void beginMRJob() {

	}

	public static class SpamDeteminationLearningDataMapper extends
			Mapper<Object, Text, Text, Text> {
		ISpamDeterminationBiz biz = (ISpamDeterminationBiz) Service.lookup(
				ServerContext.COUNTER_SERVER, "service");
		Text ham = new Text("ham");
		Text spam = new Text("spam");

		public void map(Object key, Text value, Context context)
				throws IOException, InterruptedException {

			// System.out.println(value);
			String data = value.toString();

			String[] datas = data.split("	");
			// ����Ϣ�屾����м򵥷ִʣ���ѧϰ���ݾ�ΪӢ�����ݣ���˿������ÿո������Ȼ�ִʣ�����ֱ���ÿո�ָ����Щ�򵥴ֱ�����Ϊû�д�������ţ���ҿ��Զ��������չ������������ʽ��������ź��ٽ��зִʣ�Ҳ������չ�������ĵķִʹ��ܣ�
			String[] words = datas[1].split(" ");

			// �ж�������Ϣ�Ƿ�Ϊ��Ч��Ϣ
			if ("ham".equals(datas[0])) {
				// ���õ�Counter�޷���Map��Reduce�й������ݣ�ֻ�������񳹵���ɺ��ȡ��ȷ������
				// context.getCounter(MsgConter.ConterHam).increment(1);
				biz.globalCounterValueIncrement("CounterHam", 1);

				// ������Ϣ�ķִʽ��
				for (String word : words) {
					// System.out.println("����" + word + "����������Ч��Ϣ��");
					context.write(new Text(word), ham);

				}
				// �������ϢΪ������Ϣ
			} else {
				// �������������Ϣ����
				context.getCounter(MsgConter.ConterSpam).increment(1);
				biz.globalCounterValueIncrement("CounterSpam", 1);
				// ѭ�������ִʽ��
				for (String word : words) {
					// System.out.println("����" + word + "��������������Ϣ��");
					context.write(new Text(word), spam);
				}
			}

		}
	}

	public static class SpamDeteminationLearningDataPartitioner extends
			Partitioner<Text, Text> {

		@Override
		public int getPartition(Text arg0, Text arg1, int arg2) {

			// TODO Auto-generated method stub
			char ch = arg0.toString().charAt(0);
			if (ch > 'J') {
				return 0;
			} else {
				return 1;
			}
		}

	}

	public static class SpamDeteminationLearningDataReducer extends
			Reducer<Text, Text, Text, Text> {
		// Jedis jedis = new Jedis("192.168.1.119");

		long spamNum = -1;
		long hamNum = -1;
		ISpamDeterminationBiz biz = (ISpamDeterminationBiz) Service.lookup(
				ServerContext.COUNTER_SERVER, "service");

		public void reduce(Text key, Iterable<Text> values, Context context)
				throws IOException, InterruptedException {

			if (spamNum == -1 || hamNum == -1) {

				// System.out.println("------------------------------------"+biz.getGlobalCounterValue("CounterSpam"));
				// context.getCounter(MsgConter.ConterSpam).
				// context.getCounter(MsgConter.ConterSpam).increment(1);
				// System.out.println(context.getCounter(MsgConter.ConterSpam).getValue());
				// spamNum =
				// context.getCounter(MsgConter.ConterSpam).getValue();
				// hamNum = context.getCounter(MsgConter.ConterHam).getValue();
				spamNum = biz.getGlobalCounterValue("CounterSpam");
				hamNum = biz.getGlobalCounterValue("CounterHam");
				System.out.println("ѧϰ��������Ч��Ϣ����Ŀ����:" + hamNum + ",������Ϣ����Ŀ����:"
						+ spamNum);
			}
			Jedis jedis = RedisPool.getJedis(false);

			WordInfo word = new WordInfo();
			word.setWord(key.toString());
			for (Text value : values) {
				if ("ham".equals(value.toString())) {
					word.setHamNum(word.getHamNum() + 1);
				} else {
					word.setSpamNum(word.getSpamNum() + 1);
				}
			}
			word.setWordHamPossibility(computeWordHamPossibility(word
					.getHamNum()));
			word.setWordSpamPossibility(computeWordSpamPossibility(word
					.getSpamNum()));
			try {
				jedis.set(key.toString().getBytes(),
						word.saveInstanceToBytaArray());
				// System.out.println("����"+key+"��ͳ��������Ϣ������Redis");
				//
				// System.out.println("--------------------------------------");
				// System.out.println(WordInfo.getInstanceByByteArray(jedis.get(key.getBytes())).getWord());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			RedisPool.returnResource(jedis);
		}

		/**
		 * ���ñ�Ҷ˹�������������ض����ʵ���ϢΪ��Ч��Ϣ�ĸ��ʱ������ڼ�����ʹ����������˹ƽ����������������Ŀ����Ч��Ϣ���ڵ���Ŀ����1��
		 * ��ֹ����0���� ������Ҷ˹���ʱ��ʽ����P(B|A) = P(A|B)*P(B)/P(A)
		 * 
		 * @param word
		 *            Ҫ����ĵ���
		 * @return �����˸õ��ʵ���ϢΪ��Ч��Ϣ�ĸ��ʱ�����������������˹ƽ������
		 * */
		float computeWordHamPossibility(int wordHamNum) {

			// ���㱴Ҷ˹������ʣ�+1:������˹ƽ������
			float result = ((float) wordHamNum / (float) (hamNum + 1))
					* ((float) (hamNum + 1) / (float) (hamNum + spamNum + 1))
					/ (((float) wordHamNum + 1) / (float) (hamNum + spamNum + 1));
			// ���ؼ�����
			return result;

		}

		/**
		 * ���ñ�Ҷ˹�������������ض����ʵ���ϢΪ������Ϣ�ĸ��ʱ������ڼ�����ʹ����������˹ƽ����������������Ŀ����Ч��Ϣ���ڵ���Ŀ����1��
		 * ��ֹ����0���� ������Ҷ˹���ʱ��ʽ����P(B|A) = P(A|B)*P(B)/P(A)
		 * 
		 * @param word
		 *            Ҫ����ĵ���
		 * @return �����˸õ��ʵ���ϢΪ������Ϣ�ĸ��ʱ�����������������˹ƽ������
		 * */
		float computeWordSpamPossibility(int wordSpamNum) {

			// ���㱴Ҷ˹������ʣ�+1:������˹ƽ������
			float result = ((float) wordSpamNum / (float) (spamNum + 1))
					* ((float) (spamNum + 1) / (float) (hamNum + spamNum + 1))
					/ (((float) wordSpamNum + 1) / (float) (hamNum + spamNum + 1));
			// ���ؼ�����
			return result;

		}

	}

	public static void main(String[] args) throws Exception {
		SpamDeteminationMapReduce mr = new SpamDeteminationMapReduce();
		mr.beginMR();

	}
}
