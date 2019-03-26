package task1;
import org.apache.hadoop.mapreduce.*;

import java.io.IOException;

import org.apache.hadoop.io.*;
public class MyMapper extends Mapper<LongWritable,Text,Text,IntWritable>{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		String data = value.toString();
		String [] k = data.split("[,]");
		String abc = k[1];
		int va = Integer.parseInt(k[2]);
		if(abc.equals("ABC")) {
			Text oa =  new Text(abc);
			IntWritable ob = new IntWritable(va);
			context.write(oa, ob);
		}
	}

}
