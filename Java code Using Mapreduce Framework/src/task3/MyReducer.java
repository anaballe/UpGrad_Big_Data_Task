package task3;
import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
public class MyReducer extends Reducer<Text,Text,Text,Text>{
	@Override
	protected void reduce(Text arg0, Iterable<Text> arg1, Reducer<Text, Text, Text, Text>.Context arg2)
			throws IOException, InterruptedException {
		int max = 0,i=0;
		String data="",vtr="";
		for(Text j : arg1) {
			data = j.toString();
			String [] k = data.split("[,]");
			i = Integer.parseInt(k[1]);
			if(i >= max) {
				max = i;
				vtr = k[0];
			}
		}
		String tt = Integer.toString(max);
		Text oa = new Text(vtr);
		Text ob = new Text(tt);
		arg2.write(oa, ob);
	}
	

}