package com.cognizant.flightbooking.controller;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.cognizant.flightbooking.config.AmazonConfig;

@Service
public class AmazonClient {
	
	@Autowired
	private AmazonS3 s3client;
	
	@Value("${aws.bucketName}")
	private String bucketName;

	public boolean uploadLogo(String airlineName, MultipartFile file1) {
		File file = convertMultipartFileToFile(file1);
		try {
			s3client.putObject(new PutObjectRequest(bucketName, airlineName, file).withCannedAcl(CannedAccessControlList.PublicRead));
		} catch (Exception e) {
			e.printStackTrace();
		}
		file.delete();
		return true;
	}

	private File convertMultipartFileToFile(MultipartFile file) {
		File coverted = new File(file.getOriginalFilename());
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(coverted);
			fileOutputStream.write(file.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coverted;
	}

}
