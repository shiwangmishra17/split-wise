package com.splitwiseimpl.splitwise.manager;

import com.splitwiseimpl.splitwise.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public interface UserService{

    User createUser(@RequestBody User user);
    User updateUser(@RequestBody User user);

    User getUser(@PathVariable Long userID);

    void deleteUser(@PathVariable Long userID);


}
