package com.example.flowers.jsonMapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URL;
import com.example.flowers.domain.Post;
import org.springframework.stereotype.Component;

@Component
public class MapToPost {

    @Autowired
    ObjectMapper objectMapper;

    MapToPost(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    public Post[] postUrlToJson(URL url){
        try {
            Post posts [] = objectMapper.readValue(url, Post[].class);
            return posts;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
