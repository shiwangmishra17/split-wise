package com.splitwiseimpl.splitwise.controller;

import com.splitwiseimpl.splitwise.domain.Expense;
import com.splitwiseimpl.splitwise.domain.User;
import com.splitwiseimpl.splitwise.manager.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;



    @PostMapping("/createExpense")
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseService.createExpense(expense);
    }

    @PostMapping("/updateExpense")
    public Expense updateExpense(@RequestBody Expense expense) {
        return expenseService.updateExpense(expense);
    }


    @PostMapping("/settleExpenseByUser")
    public void settleExpenseByUser(@RequestBody User User) {
        expenseService.settleExpenseByUser(User);
    }

    @PostMapping("/deleteExpenseById")
    public String deleteExpenseById(@RequestBody User User) {
        return expenseService.deleteExpenseById(User.getUserID());
    }


}
