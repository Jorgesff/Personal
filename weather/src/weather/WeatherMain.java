 package weather;
 import org.apache.hadoop.conf.Configuration;
 import org.apache.hadoop.conf.Configured;
 import org.apache.hadoop.fs.Path;
 import org.apache.hadoop.io.Text;
 import org.apache.hadoop.mapreduce.Job;
 import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
 import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
 import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
 import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
 import org.apache.hadoop.util.Tool;
 import org.apache.hadoop.util.ToolRunner;
public class WeatherMain extends Configured implements Tool {
	public static void main(String[] args) throws Exception {
		
		int res = ToolRunner.run(new Configuration(),new WeatherMain(), args);
		System.exit(res);

	}

	@Override
	public int run(String[] arg0) throws Exception {
		
		Configuration conf = this.getConf();
		Job job = Job.getInstance(conf);
		job.setJobName("Weather Precipitation");
		job.setJarByClass(WeatherMain.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);
		
		Path in = new Path(arg0[0]);
		Path out = new Path(arg0[1]);
		
		FileInputFormat.setInputPaths(job,in);
		job.setInputFormatClass(TextInputFormat.class);
		FileOutputFormat.setOutputPath(job, out);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		
		return job.waitForCompletion(true) ? 0 : 1;
	}

}
