package weather;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map extends Mapper<LongWritable, Text, Text,Text> {
	protected void map(LongWritable key, Text value,  Context context) throws InterruptedException, IOException{
		Text sonda= new Text();
		Text dateT = new Text();
		String pr = new String(),dt = new String();i
		String[] line = value.toString().split(",");
		pr = line[3];
		dt = line[1];
		/*so = value.toString().substring(0, 10);
		pr = value.toString().substring(26, 28);
		dt = value.toString().substring(12, 20);*/
		if(value.toString().contains("US") && value.toString().contains("PRCP") ){
				sonda.set( dt);	
				dateT.set(pr);
				
		}
		context.write(sonda, dateT);
	}
}
