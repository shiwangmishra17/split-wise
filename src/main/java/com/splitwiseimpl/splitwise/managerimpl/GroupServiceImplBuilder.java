package com.splitwiseimpl.splitwise.managerimpl;

import com.splitwiseimpl.splitwise.ras.ExpenseRepository;
import com.splitwiseimpl.splitwise.ras.GroupRepository;

public class GroupServiceImplBuilder {
    private GroupRepository groupRepository;

    private ExpenseRepository expenseRepository;

    public GroupServiceImplBuilder setGroupRepository(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
        return this;
    }

    public GroupServiceImpl createGroupServiceImpl() {

        return new GroupServiceImpl(groupRepository, expenseRepository);
    }
}