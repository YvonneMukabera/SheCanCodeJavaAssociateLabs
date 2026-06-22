package com.java.backend.week1advancedjavaandcorefoundations.bankingtransactionprocessor2;

public class InsufficientFundsException  extends TransactionException{
    public InsufficientFundsException( String message, String errorCode) {
        super(message, errorCode);
    }

}
