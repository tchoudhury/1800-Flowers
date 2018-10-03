package com.example.flowers.controller;

import com.example.flowers.domain.Post;
import com.example.flowers.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping("/UserIdCount")
    public String getUserIdCount(){
        return postService.uniqueUserIdTotal();
    }

    @PutMapping("/ModifyPosts/{id}")
    public Post modifyPost(@PathVariable Integer id){
        return postService.modifyPost(1, id, "1800Flowers", "1800Flowers");
    }
}
