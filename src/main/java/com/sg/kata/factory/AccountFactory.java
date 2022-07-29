package com.sg.kata.factory;

import com.sg.kata.services.AccountService;
import com.sg.kata.services.implementation.AccountServiceImplementation;

public class AccountFactory {
    private AccountFactory() {

    }
    /** Singleton */
    private static AccountFactory instance;

    public static AccountFactory getInstance() {
        if (instance == null) {
            instance = new AccountFactory();
        }
        return instance;
    }

    public AccountService buildAccountService() {
        return new AccountServiceImplementation();
    }
}
