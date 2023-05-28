package com.splitwiseimpl.splitwise.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Group {
    @Id
    @NonNull
    @Column(name = "group_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupID;

    @NonNull
    @Column(name = "group_name")
    private String groupName;

    @Column(name = "group_users")
    @OneToMany(targetEntity = User.class)
    private List<User> groupUsers;

    @Column(name="group_expenses")
    @OneToMany(targetEntity = Expense.class)
    private List<Expense> groupExpenses;


}
