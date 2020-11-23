package com.eviro.assessment.grad001.nompumelelomsiza.service;

import com.eviro.assessment.grad001.nompumelelomsiza.exception.WithdrawalAmountTooLargeException;

import java.math.BigDecimal;

public interface AccountService {

    void withdraw(Long accountNum, BigDecimal amountToWithdraw) throws WithdrawalAmountTooLargeException;

}
