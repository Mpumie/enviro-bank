package com.eviro.assessment.grad001.nompumelelomsiza.dao;

import com.eviro.assessment.grad001.nompumelelomsiza.domain.Account;
import com.eviro.assessment.grad001.nompumelelomsiza.domain.CurrentAccount;
import com.eviro.assessment.grad001.nompumelelomsiza.domain.SavingsAccount;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class SystemDB {

    private static SystemDB instance = new SystemDB();

    /**
     * private constructor to hide implicit public constructor since this is a Singleton class
     */
    private SystemDB() {
    }

    public static SystemDB getInstance() {
        return instance;
    }

    public Set<Account> getAccounts() {
        Set<Account> accounts = new HashSet<>();
        accounts.add(new SavingsAccount(101L, 1L, BigDecimal.valueOf(2000)));
        accounts.add(new SavingsAccount(102L, 2L, BigDecimal.valueOf(5000)));
        accounts.add(new CurrentAccount(103L, 3L, BigDecimal.valueOf(1000), BigDecimal.valueOf(10000)));
        accounts.add(new CurrentAccount(104L, 4L, BigDecimal.valueOf(-5000), BigDecimal.valueOf(20000)));
        return accounts;
    }
}
