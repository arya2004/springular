package com.arya2004.springularbackend.service;

import com.arya2004.springularbackend.model.Video;
import com.arya2004.springularbackend.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final MinIOService minIOService;
    private  final VideoRepository videoRepository;
    public  String uploadVideo(MultipartFile multipartFile){
        // upload to minIO
       String videoUrl =  minIOService.uploadFile(multipartFile);
        // save to mongo Database
        var video = new Video();
        video.setVideoUrl(videoUrl);
        videoRepository.save(video);
        return videoUrl;
    }
}
