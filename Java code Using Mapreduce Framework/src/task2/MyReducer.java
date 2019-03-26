package task2;
import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
public class MyReducer extends Reducer<Text,IntWritable,Text,IntWritable>{
	@Override
	protected void reduce(Text arg0, Iterable<IntWritable> arg1,
			Reducer<Text, IntWritable, Text, IntWritable>.Context arg2) throws IOException, InterruptedException {
		int sum = 0,i;
		for(IntWritable j : arg1) {
			i = j.get();
			sum = sum +i;
		}
		Text oa = new Text("Number of Viewers of BAT");
		IntWritable ob = new IntWritable(sum);
		arg2.write(oa, ob);
	}

}
