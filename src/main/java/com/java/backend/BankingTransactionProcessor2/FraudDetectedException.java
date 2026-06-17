package com.java.backend.BankingTransactionProcessor2;

public class FraudDetectedException extends TransactionException {
    public FraudDetectedException(String message,String errorCode) {
        super(message, errorCode);
    }

}
