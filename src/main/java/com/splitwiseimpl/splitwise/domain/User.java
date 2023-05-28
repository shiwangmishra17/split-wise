package com.splitwiseimpl.splitwise.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class User {


    @Id
    @NonNull
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long userID;
    @NonNull
    @Column(name = "first_name")
    private String firstName;
    @NonNull
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_groups")
    @OneToMany(targetEntity = Group.class)
    private List<Group> userGroups;

    @Column(name="user_expenses")
    @OneToMany(targetEntity = Expense.class)
    private List<Expense> userExpenses;

    @NonNull
    @Column(name = "to_pay")
    private double toPay;

    @NonNull
    @Column(name = "paid")
    private double paid;


}
