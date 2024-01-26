package com.postsbapi.controller;

import com.postsbapi.model.User;
import com.postsbapi.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserServiceImpl userService;
//    @GetMapping
//    public ResponseEntity findAll(){
//        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
//    }
    @PostMapping
    public ResponseEntity create(User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity edit(User user,@PathVariable Long id){
        user.setId(id);
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        userService.remove(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity login(String username, String password){
        User user = userService.checkLogin(username, password);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
