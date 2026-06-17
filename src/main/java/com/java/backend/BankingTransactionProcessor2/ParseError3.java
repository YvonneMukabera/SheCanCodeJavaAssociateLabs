package com.java.backend.BankingTransactionProcessor2;

public class ParseError3 {
    private int lineNumber;
    private String lineContent;
    private String reason;

    public ParseError3(int lineNumber, String lineContent, String reason) {
        this.lineNumber = lineNumber;
        this.lineContent = lineContent;
        this.reason = reason;
    }
    @Override
    public String toString() {

        return "Line"+lineNumber+": "+lineContent+" "+reason;
    }
}
