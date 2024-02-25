package com.arya2004.springularbackend.repository;

import com.arya2004.springularbackend.model.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository extends MongoRepository<Video, String> {
}
