package com.eviro.assessment.grad001.nompumelelomsiza.domain;

import com.eviro.assessment.grad001.nompumelelomsiza.dao.SystemDB;
import com.eviro.assessment.grad001.nompumelelomsiza.exception.AccountNotFoundException;
import com.eviro.assessment.grad001.nompumelelomsiza.exception.WithdrawalAmountTooLargeException;
import com.eviro.assessment.grad001.nompumelelomsiza.service.AccountService;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

import static com.eviro.assessment.grad001.nompumelelomsiza.constants.Constants.*;

public class CurrentAccount extends Account implements AccountService {

    private BigDecimal overdraft;

    public CurrentAccount() {
    }

    public CurrentAccount(Long id, Long accountNum, BigDecimal balance, BigDecimal overdraft) {
        super(id, accountNum, balance);
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(Long accountNum, BigDecimal amountToWithdraw) throws WithdrawalAmountTooLargeException {
        try {
            final SystemDB instance = SystemDB.getInstance();
            final Set<Account> accounts = instance.getAccounts();
            final Optional<Account> foundAccount = accounts.stream().filter(account -> account.getAccountNum().equals(accountNum)).findFirst();
            if (foundAccount.isPresent()) {
                final CurrentAccount account = (CurrentAccount) foundAccount.get();
                final BigDecimal overdraft = account.getOverdraft();

                final BigDecimal availableAmountToWithdraw = account.getBalance().add(overdraft);
                if (availableAmountToWithdraw.compareTo(amountToWithdraw) >= 0) {
                    // Available balance after withdrawal is sufficient, going through with the withdrawal below
                    final BigDecimal remainingBalance = availableAmountToWithdraw.subtract(amountToWithdraw);
                    account.setBalance(remainingBalance);
                    System.out.println(SUCCESS_MESSAGE + remainingBalance);
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

    public BigDecimal getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(BigDecimal overdraft) {
        this.overdraft = overdraft;
    }
}
