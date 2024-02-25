package com.arya2004.springularbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(value = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private  String id;
    private String firstName;
    private String lastname;
    private  String fullname;
    private String emailAddress;
    private Set<String> subscribedToUsers;
    private  Set<String> subscribers;
    private Set<String> likedVideos;
    private Set<String> dislikedVideos;

}