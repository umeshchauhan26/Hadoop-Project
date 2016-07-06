package com.hadoop.simplejoin;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class marksmap extends Mapper<LongWritable, Text, IntWritable, Text>
{
	public void run(LongWritable key, Text value, Context context) throws IOException, InterruptedException
	{
		Text marks=new Text();
		IntWritable rollNo=new IntWritable();
		String temp=value.toString();
		String[] arr=temp.split(",");
		if(arr.length==2)
		{
			rollNo.set(Integer.parseInt(arr[0].trim()));
			marks.set((arr[1].trim().toString()));
		}
		context.write(rollNo,marks);
	}
}
