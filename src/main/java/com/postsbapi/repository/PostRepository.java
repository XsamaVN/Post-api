package com.postsbapi.repository;

import com.postsbapi.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    @Query("SELECT p FROM Post p where p.user.id = :id and p.status LIKE 'Only Me'")
    List<Post> findAllOnlyMePostByUserId(Long id);
    @Query("select p from Post p where p.status like 'Public' order by p.likes desc")
    List<Post> findAllPublicPostByLikesDesc();
    @Query("select p from Post p where p.status like 'Public' order by p.likes desc limit 4")
    List<Post> findAllPublicPostByLikesDescLimit4();

//    List<Post> findTop4ByOrderByLikesDesc();
}
