package com.arya2004.springularbackend.controller;

import com.arya2004.springularbackend.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class HelloController {


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public  String sendHello(){
      return "Moewwwwwwwww";
    }
}
