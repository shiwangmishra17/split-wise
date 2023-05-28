package com.splitwiseimpl.splitwise.controller;

import com.splitwiseimpl.splitwise.domain.User;
import com.splitwiseimpl.splitwise.managerimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;



    @PostMapping("/createUser")
    User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PostMapping("/createUser")
    User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }


    @PostMapping("/createUser")
    User getUser(@PathVariable Long userID){
        return userService.getUser(userID);
    }


    @PostMapping("/deleteUser")
    void deleteUser(@PathVariable Long userID){
        userService.deleteUser(userID);
    }

}
