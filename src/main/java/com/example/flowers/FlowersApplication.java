package com.example.flowers;

import com.example.flowers.jsonMapper.MapToPost;
import com.example.flowers.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.flowers.domain.Post;

import java.net.URL;

@SpringBootApplication
public class FlowersApplication implements CommandLineRunner {

	@Autowired
	MapToPost mapToPost;

	@Autowired
	PostService postService;

	public static void main(String[] args) {
		SpringApplication.run(FlowersApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception{
		Post posts[] = mapToPost.postUrlToJson(new URL("http://jsonplaceholder.typicode.com/posts"));

		for (Post post: posts) {
			postService.createPost(post);
		}
	}
}
