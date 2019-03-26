package task4;
import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
public class MyReducer extends Reducer<Text,Text,Text,Text>{
	@Override
	protected void reduce(Text arg0, Iterable<Text> arg1, Reducer<Text, Text, Text, Text>.Context arg2)
			throws IOException, InterruptedException {
		String k = arg0.toString();
		Text oa = new Text(k);
		Text ob = new Text("");
		arg2.write(oa, ob);
	}
}
