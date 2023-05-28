package com.splitwiseimpl.splitwise.manager;

import com.splitwiseimpl.splitwise.domain.Expense;
import com.splitwiseimpl.splitwise.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface ExpenseService {

    Expense createExpense(@RequestBody Expense expense);

    Expense updateExpense(@RequestBody Expense expense);

    void settleExpenseByUser(@RequestBody User user);

    String deleteExpenseById(@PathVariable Long expenseID);


}
