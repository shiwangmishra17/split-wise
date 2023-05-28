package com.splitwiseimpl.splitwise.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Expense {
    @Id
    @NotNull
    @Column(name = "expense_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long expenseID;

    @NotNull
    @Column(name = "amount")
    private Double amount;

    @NotNull
    @OneToOne
    @JoinColumn(name = "to_user")
    private User toUser;

    @NotNull
    @OneToOne
    @JoinColumn(name = "from_user")
    private User fromUser;

    @NonNull
    @JoinColumn(name = "settled")
    private boolean settled;


    @NonNull
    @Column(name = "tagged_group")
    @OneToOne
    private Group taggedGroup;


}
