package com.postsbapi.service.Impl;

import com.postsbapi.model.Post;
import com.postsbapi.repository.PostRepository;
import com.postsbapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;
    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
    postRepository.deleteById(id);
    }

    public List<Post> findAllOnlyMePostByUserId(Long id){
        return postRepository.findAllOnlyMePostByUserId(id);
    }
    public List<Post> findAllPublicPostByLikesDesc(){
        return postRepository.findAllPublicPostByLikesDesc();
    }
    public List<Post> findAllPublicPostByLikesDescLimit4(){
        return postRepository.findAllPublicPostByLikesDescLimit4();
    }
}
