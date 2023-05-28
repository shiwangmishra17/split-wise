package com.splitwiseimpl.splitwise.manager;

import com.splitwiseimpl.splitwise.domain.Expense;
import com.splitwiseimpl.splitwise.domain.Group;
import com.splitwiseimpl.splitwise.dto.ExpenseDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public interface GroupService {

    Group createGroup(@RequestBody Group group);

    Group updateGroup(@RequestBody Group group);

    String settleGroupExpenses(@PathVariable Long groupID);

    String addExpense(@RequestBody ExpenseDetails expenseDetails);


}
