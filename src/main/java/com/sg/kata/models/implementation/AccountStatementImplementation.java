package com.sg.kata.models.implementation;

import com.sg.kata.enums.OperationTypeEnum;
import com.sg.kata.models.AccountStatement;

import java.time.LocalDateTime;

public class AccountStatementImplementation implements AccountStatement {

    private OperationTypeEnum operationType;
    private LocalDateTime date;
    private double amount;
    private double balance;

    @Override
    public OperationTypeEnum getOperationType() {
        return operationType;
    }
    public void setOperationType(OperationTypeEnum operationType) {
        this.operationType = operationType;
    }

    @Override
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    @Override
    public double getAmount() {
            return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
