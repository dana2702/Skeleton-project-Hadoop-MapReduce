# Skeleton-project-Hadoop-MapReduce

## About
Hadoop MapReduce application for calculating normalized average product ratings, based on user rating behavior.  
Developed as part of the Big Data course at Politecnico di Torino.

## Description
This project processes user ratings from the Amazon food dataset to reduce user bias.  
The normalization removes each user's personal average rating, then computes the normalized average rating per product.

Steps:
- Read and parse the dataset (ignoring the header)
- Compute each user’s average score
- Normalize each rating by subtracting the user’s average
- Calculate, for each product, the average of its normalized ratings

The dataset used:
- Path on HDFS: `/data/students/bigdata-01QYD/Lab4/Reviews.csv`
- Fields of interest: `ProductId`, `UserId`, and `Score`

Output:
- For each product, its normalized average rating (format: `ProductId, normalized average rating`)

This implementation is optimized for sparse user-product matrices, assuming each user rates a relatively small number of products.

## Technologies
- Java
- Hadoop MapReduce
- HDFS

## Author
Developed by Dana Hadassi as part of the Big Data course at Politecnico di Torino.
