package com.arya2004.springularbackend.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String uploadFile(MultipartFile file);
}
