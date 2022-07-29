package com.sg.kata;

import com.sg.kata.enums.OperationTypeEnum;
import com.sg.kata.factory.AccountFactory;
import com.sg.kata.models.AccountStatement;
import com.sg.kata.services.AccountService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

public class AccountTest {
    @Test
    public void testDepositAmountZero() {
        try {
        AccountService service = AccountFactory.getInstance().buildAccountService();
        service.deposit(0);
    } catch (IllegalArgumentException expected) {
    }
    }

    @Test
    public void testDepositAmountNegative() {
        try {
        AccountService service = AccountFactory.getInstance().buildAccountService();
        service.deposit(-0.1);
        } catch (IllegalArgumentException expected) {
        }
    }

    @Test
    public void testDeposit1Amount() {
        AccountService service = AccountFactory.getInstance().buildAccountService();
        AccountStatement statement = service.deposit(0.1);
        Assertions.assertNotNull(statement);
        Assertions.assertEquals(OperationTypeEnum.DEPOSIT, statement.getOperationType());
        Assertions.assertNotNull(statement.getDate());
        Assertions.assertEquals(0.1, statement.getAmount());
        Assertions.assertEquals(0.1, statement.getBalance());
    }

    @Test
    public void testDeposit2Amounts() {
        AccountService service = AccountFactory.getInstance().buildAccountService();
        AccountStatement statement = service.deposit(0.1);
        Assertions.assertEquals(0.1, statement.getAmount());
        Assertions.assertEquals(0.1, statement.getBalance());
        statement = service.deposit(1.2);
        Assertions.assertEquals(1.2, statement.getAmount());
        Assertions.assertEquals(1.3, statement.getBalance());
    }

    @Test
    public void testWithdrawalAmountZero() {

            try {
        AccountService service = AccountFactory.getInstance().buildAccountService();
        service.withdrawal(0);
            } catch (IllegalArgumentException expected) {
            }
    }

    @Test
    public void testWithdrawalAmountNegative() {

                try {
        AccountService service = AccountFactory.getInstance().buildAccountService();
        service.withdrawal(-0.1);
                } catch (IllegalArgumentException expected) {
                }
    }

    @Test
    public void testWithdrawal1Amount() {

        AccountService service = AccountFactory.getInstance().buildAccountService();
        AccountStatement statement = service.withdrawal(0.1);
        Assertions.assertNotNull(statement);
        Assertions.assertEquals(OperationTypeEnum.WITHDRAWAL, statement.getOperationType());
        Assertions.assertNotNull(statement.getDate());
        Assertions.assertEquals(0.1, statement.getAmount());
        Assertions.assertEquals(-0.1, statement.getBalance());
    }

    @Test
    public void testWithdrawal2Amounts() {
        AccountService service = AccountFactory.getInstance().buildAccountService();
        AccountStatement statement = service.withdrawal(0.1);
        Assertions.assertEquals(0.1, statement.getAmount());
        Assertions.assertEquals(-0.1, statement.getBalance());
        statement = service.withdrawal(1.2);
        Assertions.assertEquals(1.2, statement.getAmount());
        Assertions.assertEquals(-1.3, statement.getBalance());
    }

    @Test
    public void testHistoryEmpty() {
        AccountService service = AccountFactory.getInstance().buildAccountService();
        List<AccountStatement> statements = service.history();
        Assertions.assertEquals(0, statements.size());
    }

    @Test
    public void testHistoryNotEmpty() {
        AccountService service = AccountFactory.getInstance().buildAccountService();
        List<AccountStatement> expectedStatements = new ArrayList<>();
        expectedStatements.add(service.deposit(0.1));
        expectedStatements.add(service.withdrawal(2));
        expectedStatements.add(service.deposit(3));
        expectedStatements.add(service.deposit(5.7));
        expectedStatements.add(service.withdrawal(6.6));
        List<AccountStatement> statements = service.history();
        Assertions.assertEquals(expectedStatements, statements);
    }
}
