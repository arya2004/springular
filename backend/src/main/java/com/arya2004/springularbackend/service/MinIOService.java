package com.arya2004.springularbackend.service;

import io.minio.*;
import io.minio.errors.*;
import io.minio.http.Method;
import io.minio.messages.Bucket;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class MinIOService implements  FileService{
    @Override
    public String uploadFile(MultipartFile file){
        MinioClient minioClient = demo();
        //Prepare Key
        var filenameExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());




        var key = UUID.randomUUID().toString() + "." + "mp4";
        //try uploading
        try {

            Path tempFilePath = Files.createTempFile(UUID.randomUUID().toString(), ".mp4");
            Files.write(tempFilePath, file.getBytes());


            List<Bucket> b = minioClient.listBuckets() ;
            ObjectWriteResponse resp =  minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket("hello").object(key).filename(tempFilePath.toString()).build());

        } catch (MinioException e){
            System.out.println(e);
        } catch (Exception e) {
           throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while uploading file");
        }

        Map<String, String> reqParams = new HashMap<String, String>();
        reqParams.put("response-content-type", "application/json");
        try {
            String url =
                    minioClient.getPresignedObjectUrl(
                            GetPresignedObjectUrlArgs.builder()
                                    .method(Method.GET)
                                    .bucket("hello")
                                    .object(key)
                                    .expiry(168, TimeUnit.HOURS)

                                    .build());
            return url;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while uploading file");

        }


    }

    private  static MinioClient demo(){
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint("localhost", 9000, false)
                        .credentials("!Ziegler00601221", "!Ziegler00601221")
                        .build();

        return minioClient;
    }
}
