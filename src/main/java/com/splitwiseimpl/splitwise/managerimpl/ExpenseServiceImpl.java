package com.splitwiseimpl.splitwise.managerimpl;

import com.splitwiseimpl.splitwise.domain.Expense;
import com.splitwiseimpl.splitwise.domain.User;
import com.splitwiseimpl.splitwise.manager.ExpenseService;
import com.splitwiseimpl.splitwise.ras.ExpenseRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }


    @Override
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense updateExpense(Expense expense) {
        Expense oldExpense ;
        Optional<Expense> optionalExpense = expenseRepository.findById(expense.getExpenseID());
        if (optionalExpense.isPresent()) {
            oldExpense = optionalExpense.get();
            oldExpense.setTaggedGroup(expense.getTaggedGroup());
            if (!oldExpense.isSettled()) {
                oldExpense.setAmount(expense.getAmount());
                oldExpense.setToUser(expense.getToUser());
                oldExpense.setFromUser(expense.getFromUser());
            }
            expenseRepository.save(oldExpense);
        }
        else
            return new Expense();
        return oldExpense;

    }

    public void settleExpenseByUser(User user) {
        List<Expense> expenseListForUser = expenseRepository.findByUserAndisSettled(user);


        expenseListForUser.forEach(expense->{
            expense.getToUser().setToPay(expense.getToUser().getToPay()+expense.getAmount());
            expense.getFromUser().setToPay(expense.getFromUser().getToPay()-expense.getAmount());
            expense.setSettled(true);
        });

    }

    public String deleteExpenseById(@PathVariable Long expenseID) {
        Expense oldExpense;
        Optional<Expense> optionalExpense = expenseRepository.findById(expenseID);
        if(optionalExpense.isPresent())
        {
            oldExpense = optionalExpense.get();
            if(!oldExpense.isSettled())
                expenseRepository.deleteById(expenseID);
            else
                return "The Expense cannot be deleted since it has already been settled.";
            return "The Expense has been deleted successfully";
        }
        return "The Expense does not exist.";
    }
}
