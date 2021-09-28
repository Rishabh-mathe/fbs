package com.cognizant.flightbooking.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Builder;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AmazonConfig {
	 	@Value("${aws.endpointUrl}")
	    private String endpointUrl;
	    @Value("${aws.bucketName}")
	    private String bucketName;
	    @Value("${aws.accessKey}")
	    private String accessKey;
	    @Value("${aws.secretKey}")
	    private String secretKey;
	    
	    @Bean
	    public AmazonS3 s3() {
	    	AWSCredentials awsCredentials =
	                new BasicAWSCredentials(accessKey, secretKey);
	    	return AmazonS3ClientBuilder
	    			.standard()
	    			.withRegion("ap-south-1")
	    			.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
	    			.build();
	    }
}
