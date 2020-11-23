package com.eviro.assessment.grad001.nompumelelomsiza.constants;

import java.math.BigDecimal;

public class Constants {

    public static final BigDecimal MIN_BALANCE = BigDecimal.valueOf(1000);
    public static final BigDecimal MAX_OVERDRAFT_LIMIT = BigDecimal.valueOf(100000);
    public static final String INSUFFICIENT_FUNDS = "Insufficient funds available, please try a lower amount.";
    public static final String ACCOUNT_NOT_FOUND = "Account with provided account number could not be found!";
    public static final String TECH_ERROR = "Some technical error occurred. Please contact EnviroBank Administrators.";
    public static final String SUCCESS_MESSAGE = "Amount withdrawn successfully! Remaining balance after withdrawal is: R ";
}
