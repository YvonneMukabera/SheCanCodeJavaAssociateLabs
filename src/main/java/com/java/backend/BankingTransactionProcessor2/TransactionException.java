package com.java.backend.BankingTransactionProcessor2;

public class TransactionException extends Exception{
    private String errorCode;

    public TransactionException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public String getErrorCode() {
        return errorCode;
    }
    @Override
    public String getMessage() {
         return "["+ errorCode +"] " + super.getMessage();
    }
}
