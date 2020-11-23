package com.eviro.assessment.grad001.nompumelelomsiza.service;

import com.eviro.assessment.grad001.nompumelelomsiza.dao.SystemDB;
import com.eviro.assessment.grad001.nompumelelomsiza.domain.Account;
import com.eviro.assessment.grad001.nompumelelomsiza.exception.AccountNotFoundException;
import com.eviro.assessment.grad001.nompumelelomsiza.exception.WithdrawalAmountTooLargeException;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

import static com.eviro.assessment.grad001.nompumelelomsiza.constants.Constants.*;

public class SavingsAccount extends Account implements AccountService {

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(Long id, Long accountNum, BigDecimal balance) {
        super(id, accountNum, balance);
    }

    @Override
    public void withdraw(Long accountNum, BigDecimal amountToWithdraw) throws WithdrawalAmountTooLargeException {
        try {
            final SystemDB instance = SystemDB.getInstance();
            final Set<Account> accounts = instance.getAccounts();
            final Optional<Account> foundAccount = accounts.stream().filter(account -> account.getAccountNum().equals(accountNum)).findFirst();

            if (foundAccount.isPresent()) {
                final Account account = foundAccount.get();
                final BigDecimal balance = account.getBalance();
                final BigDecimal balanceAfterWithdrawal = balance.subtract(amountToWithdraw);
                if (balanceAfterWithdrawal.compareTo(MIN_BALANCE) >= 0) {
                    // Available balance after withdrawal is sufficient ( >= R1000), going through with the withdrawal below
                    account.setBalance(balanceAfterWithdrawal);
                    System.out.println("Remaining balance after withdrawal is: R " + balanceAfterWithdrawal);
                } else {
                    throw new WithdrawalAmountTooLargeException(INSUFFICIENT_FUNDS);
                }
            } else {
                throw new AccountNotFoundException(ACCOUNT_NOT_FOUND);
            }
        } catch (WithdrawalAmountTooLargeException | AccountNotFoundException e) {
            System.out.println(INSUFFICIENT_FUNDS);
            throw e;
        } catch (Exception e) {
            // Any other unexpected exception is caught here
            System.out.println(TECH_ERROR);
        }
    }
}
