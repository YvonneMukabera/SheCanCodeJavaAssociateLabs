package com.java.backend.week1advancedjavaandcorefoundations.bankingtransactionprocessor2;

public class FraudDetectedException extends TransactionException {
    public FraudDetectedException(String message,String errorCode) {
        super(message, errorCode);
    }

}
