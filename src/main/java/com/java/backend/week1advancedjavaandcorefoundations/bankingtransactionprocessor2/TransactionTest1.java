package com.java.backend.week1advancedjavaandcorefoundations.bankingtransactionprocessor2;
/*
 Transfers money from one account to another.

 May throw:
 - InsufficientFundsException
 - FraudDetectedException
 */
public class TransactionTest1 {
    public static void transfer(Account from, Account to, double amount)throws TransactionException {
        //check available balance
        if (amount > from.getBalance()) {
            throw new InsufficientFundsException( "Transfer from " + from.getOwner()
                    + " to " + to.getOwner()
                    + " failed. Requested: "
                    + amount
                    + ", Available: "
                    + from.getBalance(),
                    "TXN001");
        }
        // fraud detection rule
        if (amount > 100000) {
            throw new FraudDetectedException("Transfer from " + from.getOwner()
                    + " to " + to.getOwner()
                    + " blocked. Requested amount "
                    + amount
                    + " exceeds limit of 10000.",
                    "TXN002");
        }
        // perform transfer
        from.withdraw(amount);
        to.deposit(amount);
        System.out.println("Transfer successful: "
                + amount
                + " transferred from "
                + from.getOwner()
                + " to "
                + to.getOwner());
    }
    public static void main(String[]args){
        //create accounts
        //transfer with no errors
        Account yvonne = new Account("Yvonne",80000);
        Account  billy = new Account("Billy",70000);
        //transfer with errors
        Account nziza = new Account("Nziza",10000);
        Account  mwiza = new Account("Mwiza",3000);
        // fraud test
        Account kenny = new Account("Kenny",500000);
        Account  aime = new Account("Aime",90000);

        System.out.println("\nBEFORE TRANSFER: ");
        System.out.println(yvonne);
        System.out.println(billy);
        System.out.println(nziza);
        System.out.println(mwiza);
        System.out.println(kenny);
        System.out.println(aime+"\n");
        // for no error
        try{
           transfer(
                   yvonne,billy,2500

           );
        }catch (TransactionException e){
            System.out.println("Transaction failed:"+e.getMessage());
        }
        // for error of insufficient funds
        try{
            transfer(
                    nziza,mwiza,25000

            );
        }catch (TransactionException e){
            System.out.println("Transaction failed:"+e.getMessage());
        }
      // for error of fraud
        try{
            transfer(
                    kenny,aime,200000

            );
        }catch (TransactionException e){
            System.out.println("Transaction failed:"+e.getMessage());
        }
       System.out.println("\nAFTER TRANSFER: ");
        System.out.println(yvonne);
        System.out.println(billy);
        System.out.println(nziza);
        System.out.println(mwiza);
        System.out.println(kenny);
        System.out.println(aime);

    }
}
