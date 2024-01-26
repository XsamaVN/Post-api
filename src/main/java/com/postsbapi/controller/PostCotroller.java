package com.postsbapi.controller;

import com.postsbapi.model.Post;
import com.postsbapi.service.Impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/posts")
public class PostCotroller {
    @Autowired
    PostServiceImpl postService;
    @GetMapping
    public ResponseEntity findAll(){
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity create(Post post){
        return new ResponseEntity<>(postService.save(post), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity edit(Post post,@PathVariable Long id){
        post.setId(id);
        return new ResponseEntity<>(postService.save(post), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        postService.remove(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
    }
    @GetMapping("/status/only-me/{id}")
    public ResponseEntity findAllOnlyMePostByUserId(@PathVariable Long id){
        return new ResponseEntity<>(postService.findAllOnlyMePostByUserId(id),HttpStatus.OK);
    }
    @GetMapping("/sort-by-like-desc")
    public ResponseEntity findAllPublicPostByLikesDesc(){
        return new ResponseEntity<>(postService.findAllPublicPostByLikesDesc(),HttpStatus.OK);
    }
    @GetMapping("/sort-by-like-desc/limit-4")
    public ResponseEntity findAllPublicPostByLikesDescLimit4(){
        return new ResponseEntity<>(postService.findAllPublicPostByLikesDescLimit4(),HttpStatus.OK);
    }
}
