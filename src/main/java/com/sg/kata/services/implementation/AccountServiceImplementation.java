package com.sg.kata.services.implementation;

import com.sg.kata.enums.OperationTypeEnum;
import com.sg.kata.models.AccountStatement;
import com.sg.kata.models.implementation.AccountStatementImplementation;
import com.sg.kata.services.AccountService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccountServiceImplementation implements AccountService {

    private List<AccountStatement> accountStatements = new ArrayList<>();

    public AccountStatement deposit(final double pAmount) {
        checkAmount(pAmount);
        return addStatement(pAmount, OperationTypeEnum.DEPOSIT);
    }

    public AccountStatement withdrawal(final double pAmount) {

        checkAmount(pAmount);
        return addStatement(-pAmount, OperationTypeEnum.WITHDRAWAL);
    }

    public List<AccountStatement> history() {
        return accountStatements;
    }

    private void checkAmount(final double pAmount) {
        if (pAmount <= 0) {
            throw new IllegalArgumentException("The amount must be greater than zero");
        }
    }

    private AccountStatement addStatement(final double pAmount, final OperationTypeEnum pOperationType) {

        // Compute the balance
        double balance = pAmount;
        if (!accountStatements.isEmpty()) {
            balance = accountStatements.get(accountStatements.size() - 1).getBalance() + pAmount;
        }

        // Build a new account statement
        AccountStatementImplementation result = new AccountStatementImplementation();
        result.setOperationType(pOperationType);
        result.setDate(LocalDateTime.now());
        result.setAmount(Math.abs(pAmount));
        result.setBalance(balance);

        accountStatements.add(result);

        return result;
    }
}

