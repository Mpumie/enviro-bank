package com.eviro.assessment.grad001.nompumelelomsiza;

import com.eviro.assessment.grad001.nompumelelomsiza.service.CurrentAccount;
import com.eviro.assessment.grad001.nompumelelomsiza.service.SavingsAccount;
import com.eviro.assessment.grad001.nompumelelomsiza.exception.AccountNotFoundException;
import com.eviro.assessment.grad001.nompumelelomsiza.exception.WithdrawalAmountTooLargeException;

import java.math.BigDecimal;

public class ApplicationTester {

    public static void main(String[] args) {
        try {
            final CurrentAccount currentAccountSuccess = new CurrentAccount(103L, 3L, BigDecimal.valueOf(3000L), BigDecimal.valueOf(25000L));
            currentAccountSuccess.withdraw(3L, BigDecimal.valueOf(2356));

            final CurrentAccount currentAccountFailure = new CurrentAccount(104L, 4L, BigDecimal.valueOf(7000), BigDecimal.valueOf(25000L));
            currentAccountFailure.withdraw(4L, BigDecimal.valueOf(72356));

            final SavingsAccount savingsAccountSuccess = new SavingsAccount();
            savingsAccountSuccess.withdraw(1L, BigDecimal.valueOf(200));

            final SavingsAccount savingsAccountFailure = new SavingsAccount();
            savingsAccountFailure.withdraw(2L, BigDecimal.valueOf(16000));
        } catch (WithdrawalAmountTooLargeException e) {
            System.out.println(e.getMessage());
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
