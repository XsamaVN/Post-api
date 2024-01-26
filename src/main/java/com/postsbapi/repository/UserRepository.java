package com.postsbapi.repository;

import com.postsbapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u where u.username like :username and u.password like :password")
    User findByUsernameAndPasswords(String username, String password);
}
