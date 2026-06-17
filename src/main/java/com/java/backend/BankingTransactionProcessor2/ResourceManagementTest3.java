package com.java.backend.BankingTransactionProcessor2;

public class ResourceManagementTest3 {
    public static void main(String[] args) {
        TransactionProcessor3 tp=new TransactionProcessor3();
        tp.processFile("transactions.csv","failed_transactions.txt");
    }
}
