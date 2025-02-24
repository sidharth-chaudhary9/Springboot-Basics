package com.example.RestApiPrac;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostsController {
    private List<Posts> posts;
    PostsController(){
        posts=new ArrayList<>();
        posts.add(new Posts.PostsBuilder().setId(5).setTitle("Travelling").build());
        posts.add(new Posts.PostsBuilder().setId(9).setBody("Yo Yo Yo 1483").setTitle("Breaking bad").setUserId(1).build());
    }
    @GetMapping("/posts")
    public List<Posts> getAllPosts(){
        return posts;
    }
    @PostMapping("/posts")
    public Posts createPost(@RequestBody Posts newpost ){
        posts.add(newpost);
        return newpost;
    }

}
