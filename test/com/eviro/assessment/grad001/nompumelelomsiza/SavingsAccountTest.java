package com.eviro.assessment.grad001.nompumelelomsiza;

import com.eviro.assessment.grad001.nompumelelomsiza.domain.SavingsAccount;
import com.eviro.assessment.grad001.nompumelelomsiza.exception.WithdrawalAmountTooLargeException;
import org.junit.Test;

import java.math.BigDecimal;

import static com.eviro.assessment.grad001.nompumelelomsiza.constants.Constants.INSUFFICIENT_FUNDS;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class SavingsAccountTest {

    @Test
    public void withdrawalAmountTooLargeShouldThrowAmountTooLargeException() throws WithdrawalAmountTooLargeException {

        final WithdrawalAmountTooLargeException exception = assertThrows(WithdrawalAmountTooLargeException.class, () -> {
            new SavingsAccount().withdraw(1L, BigDecimal.valueOf(10000));
        });

        final String exceptionMessage = exception.getMessage();
        assertTrue(exceptionMessage.equals(INSUFFICIENT_FUNDS));
    }
}
