package it.polito.bigdata.hadoop.lab;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * Lab  - Mapper
 */

/* Set the proper data types for the (key,value) pairs */
class MapperBigData1 extends Mapper<
                    LongWritable, // Input key type
                    Text,         // Input value type
                    Text,         // Output key type
                    ProductIdRatingWritable> {// Output value type
    
    protected void map(
            LongWritable key,   // Input key type
            Text value,         // Input value type
            Context context) throws IOException, InterruptedException {

    		/* Implement the map method */ 

            String[] words = value.toString().split(",");

            if(!"Id".equals(words[0])){
                String p = words[1];
                String id = words[2];
                double score = Double.parseDouble(words[6]);

                ProductIdRatingWritable pair = new ProductIdRatingWritable();
                pair.setProductId(p);
                pair.setRating(score);

                context.write(new Text(id), pair);
            }
    }
}
