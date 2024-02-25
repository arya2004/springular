package com.arya2004.springularbackend.controller;


import com.arya2004.springularbackend.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/videos")
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  String uploadvideo(@RequestParam("file")MultipartFile file){
        return videoService.uploadVideo(file);
    }
}
