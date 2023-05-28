package com.splitwiseimpl.splitwise.managerimpl;

import com.splitwiseimpl.splitwise.domain.Expense;
import com.splitwiseimpl.splitwise.domain.Group;
import com.splitwiseimpl.splitwise.domain.User;
import com.splitwiseimpl.splitwise.dto.ExpenseDetails;
import com.splitwiseimpl.splitwise.manager.GroupService;
import com.splitwiseimpl.splitwise.ras.ExpenseRepository;
import com.splitwiseimpl.splitwise.ras.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    private final ExpenseRepository expenseRepository;

    public GroupServiceImpl(GroupRepository groupRepository, ExpenseRepository expenseRepository) {
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
    }

    public Group createGroup(Group group) {

        return groupRepository.save(group);
    }

    public Group updateGroup(Group group) {
        Group oldGroup;
        Optional<Group> optionalGroup = groupRepository.findById(group.getGroupID());
        if (optionalGroup.isPresent()) {
            oldGroup = optionalGroup.get();
            oldGroup.setGroupUsers(group.getGroupUsers());
            oldGroup.setGroupName(group.getGroupName());
        }
        else
            return new Group();
        return oldGroup;

    }

    @Override
    public String settleGroupExpenses(Long groupID) {

        Group oldGroup;
        Optional<Group> optionalGroup = groupRepository.findById(groupID);
        if(optionalGroup.isPresent())
        {
            oldGroup = optionalGroup.get();
            ExpenseDetails expenseDetails = expenseRepository.findByIdAndIsSettled(oldGroup.getGroupID());
            if(expenseDetails!=null && expenseDetails.getUsers()!=null){
                expenseDetails.getUsers().stream().forEach(user -> {

                });
            }
        }
        return "The group does not exist to be settled.";
    }


    @Override
    public String addExpense(ExpenseDetails expenseDetailsList) {
        List<User> userList = expenseDetailsList.getUsers();
        if(userList!=null){
            for(User user:userList) {
                Expense expense = new Expense();
                expense.setTaggedGroup(expenseDetailsList.getTaggedGroup());
                expense.setAmount(expense.getAmount()/ userList.size());
                expense.setFromUser(expenseDetailsList.getPaidBy());
                expense.setToUser(user);
                expense.setSettled(false);
                expenseRepository.save(expense);
            }
            return "Expense created.";
        }

        return "No users selected";
    }


}
