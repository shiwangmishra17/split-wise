package com.splitwiseimpl.splitwise.dto;

import com.splitwiseimpl.splitwise.domain.Group;
import com.splitwiseimpl.splitwise.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDetails {
    private List<User> users;

    private User paidBy;

    private Double amount;

    private Long groupID;

    private Group taggedGroup;


}
