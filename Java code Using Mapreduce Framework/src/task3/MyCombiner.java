package task3;
import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
public class MyCombiner extends Reducer<Text,Text,Text,Text>{
		@Override
		protected void reduce(Text arg0, Iterable<Text> arg1, Reducer<Text, Text, Text, Text>.Context arg2)
				throws IOException, InterruptedException {
			int sum = 0,i;
			String p="";
			for(Text j : arg1) {
				p = j.toString();
				i = Integer.parseInt(p);
				sum = sum +i;
			}
			String vtr = arg0.toString();
			
			String rr = Integer.toString(sum);
			String rt = vtr+","+rr;
			Text oa = new Text("frequency");
			Text ob = new Text(rt);
			arg2.write(oa, ob);
		}
}
