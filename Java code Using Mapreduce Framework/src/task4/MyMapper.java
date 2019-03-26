package task4;
import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
public class MyMapper extends Mapper<LongWritable,Text,Text,Text>{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		String data = value.toString();
		String [] k = data.split("[,]");
		String chan = k[1];
		if(chan.equals("ZOO") || chan.equals("NOX") || chan.equals("ABC")) {
			String show = k[0];
			Text oa = new Text(show);
			Text ob = new Text("");
			context.write(oa, ob);
		}
	}
}
