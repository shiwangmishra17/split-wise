package com.splitwiseimpl.splitwise.ras;

import com.splitwiseimpl.splitwise.domain.Expense;
import com.splitwiseimpl.splitwise.domain.User;
import com.splitwiseimpl.splitwise.dto.ExpenseDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    List<Expense> findByUserAndisSettled(User user);

    ExpenseDetails findByIdAndIsSettled(Long groupID);

    User findByIdAndIsNotSettled(Long userID);
}
