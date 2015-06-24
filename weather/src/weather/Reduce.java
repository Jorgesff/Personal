package weather;
import java.io.IOException;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;

public class Reduce extends Reducer<Text, Text,Text, Text> {
	protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException{
//		Text nKey = new Text();
		Text nValue = new Text();
//		long maxpr = 0;
//		String date = new String();
		String[] line = values.iterator().next().toString().split(",");
		while(values.iterator().hasNext()){	
			if(line[2].equals("SNOW")){
			nValue.set(line[0]);
			context.write(key, nValue);
			}
			//if(Long.parseLong(line[1])> maxpr){
			//	maxpr = Long.parseLong(line[1]);
			//	date = key.toString();
			//}
			
		}
	//	nKey.set(" data: "+date );
	//	nValue.set("precipitação maxima: "+maxpr);
	//	context.write(nKey, nValue);
	}
}
