package com.eviro.assessment.grad001.nompumelelomsiza;

import com.eviro.assessment.grad001.nompumelelomsiza.domain.CurrentAccount;
import com.eviro.assessment.grad001.nompumelelomsiza.exception.WithdrawalAmountTooLargeException;
import org.junit.Test;

import java.math.BigDecimal;

import static com.eviro.assessment.grad001.nompumelelomsiza.constants.Constants.INSUFFICIENT_FUNDS;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class CurrentAccountTest {

    @Test
    public void withdrawalAmountTooLargeShouldThrowAmountTooLargeException() {

        final WithdrawalAmountTooLargeException exception = assertThrows(WithdrawalAmountTooLargeException.class, () -> {
            new CurrentAccount().withdraw(3L, BigDecimal.valueOf(7204433));
        });

        final String exceptionMessage = exception.getMessage();
        assertTrue(exceptionMessage.equals(INSUFFICIENT_FUNDS));
    }

}
