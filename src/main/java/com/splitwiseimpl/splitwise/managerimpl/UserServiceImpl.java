package com.splitwiseimpl.splitwise.managerimpl;

import com.splitwiseimpl.splitwise.domain.User;
import com.splitwiseimpl.splitwise.manager.ExpenseService;
import com.splitwiseimpl.splitwise.manager.UserService;
import com.splitwiseimpl.splitwise.ras.ExpenseRepository;
import com.splitwiseimpl.splitwise.ras.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    ExpenseService expenseService;


    private final UserRepository userRepository;

    private final ExpenseRepository expenseRepository;


    public UserServiceImpl(UserRepository userRepository, ExpenseRepository expenseRepository) {
        this.userRepository = userRepository;
        this.expenseRepository = expenseRepository;
    }


    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return null;
    }

    public User getUser(Long userID)
    {
        return userRepository.findById(userID).orElse(null);
    }

    public void deleteUser(Long userID) {
        Optional<User> user = userRepository.findById(userID);
        if(user.isPresent()) {
            expenseService.settleExpenseByUser(expenseRepository.findByIdAndIsNotSettled(userID));
            userRepository.deleteById(userID);
        }
    }

}
