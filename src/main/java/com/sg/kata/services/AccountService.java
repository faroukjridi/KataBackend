package com.sg.kata.services;

import com.sg.kata.models.AccountStatement;

import java.util.List;

public interface AccountService {

    AccountStatement deposit(final double pAmount);
    AccountStatement withdrawal(final double pAmount);
    List<AccountStatement> history();
}
