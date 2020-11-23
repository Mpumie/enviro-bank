package com.eviro.assessment.grad001.nompumelelomsiza.domain;

import java.math.BigDecimal;

public class Account {

    private Long id;
    private Long accountNum;
    private BigDecimal balance;

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public Account(Long id, Long accountNum, BigDecimal balance) {
        this.id = id;
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountNum() {
        return accountNum;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
