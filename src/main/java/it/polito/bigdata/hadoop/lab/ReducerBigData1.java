package it.polito.bigdata.hadoop.lab;

import java.io.IOException;
import java.util.Vector;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * Lab - Reducer
 */

/* Set the proper data types for the (key,value) pairs */
class ReducerBigData1 extends Reducer<
                Text,           // Input key type
                ProductIdRatingWritable,    // Input value type
                Text,           // Output key type
                DoubleWritable> {  // Output value type
    
    @Override
    protected void reduce(
        Text key, // Input key type
        Iterable<ProductIdRatingWritable> values, // Input value type
        Context context) throws IOException, InterruptedException {

		/* Implement the reduce method */

        int count = 0;
        double sum = 0;
        Vector<ProductIdRatingWritable> list = new Vector<>();

        for (ProductIdRatingWritable value : values) {
            count++;
            list.add(value);
            sum = sum + value.getRating();
        }   

        double avg = (double) (sum / count);

        for(ProductIdRatingWritable v : list){
            context.write(new Text(v.getProductId()), new DoubleWritable(v.getRating()-avg));
        }



    	
    }
}
