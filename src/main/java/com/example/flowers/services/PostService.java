package com.example.flowers.services;

import com.example.flowers.domain.Post;
import com.example.flowers.repository.PostRepository;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public void createPost(Integer userId, Integer id, String title, String body){
        if(!postRepository.existsById(id)){
            postRepository.save(new Post(userId, id, title, body));
        }
    }

    public void createPost(Post post){
        if(!postRepository.existsById(post.getid())){
            postRepository.save(post);
        }
    }

    public Post modifyPost(Integer userId, Integer id, String title, String body){
        if(postRepository.existsById(id)){
            postRepository.save(new Post(userId, id, title, body));
            return postRepository.findById(id).get();
        }

        return null;
    }

    public Iterable<Post> lookup(){
        return postRepository.findAll();
    }

    public long total(){
        return postRepository.count();
    }

    public String uniqueUserIdTotal(){
        Iterator<Post> iterator = lookup().iterator();

        Set<Integer> userIds = new HashSet<>();
        while(iterator.hasNext()){
            userIds.add(iterator.next().getUserId());
        }

        ObjectNode node = JsonNodeFactory.instance.objectNode();

        node.put("UserIdCount", userIds.size());

        return node.toString();
    }
}
