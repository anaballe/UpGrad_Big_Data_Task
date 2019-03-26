package task3;
import org.apache.hadoop.mapreduce.*;

import java.io.IOException;

import org.apache.hadoop.io.*;
public class MyMapper extends Mapper<LongWritable,Text,Text,Text>{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		String data = value.toString();
		String [] k = data.split("[,]");
		String abc = k[1];
		//int va = Integer.parseInt(k[2]);
		if(abc.equals("ABC")) {
			String bb = k[0];
			Text oa =  new Text(bb);
			Text ob = new Text(k[2]);
			context.write(oa, ob);
	}

}
}
