package com.java.backend.week1advancedjavaandcorefoundations.bankingtransactionprocessor2;
import java.sql.SQLException;
public class DataAccessTest2 {
    public static void main (String[]args){
        AccountRepository2 accountRepository = new AccountRepository2();
        try{
            accountRepository.getAccountBalance("ACC001");
        }catch (DataAccessException2 e){
            if(e.getCause() instanceof SQLException){
                System.out.println("Test Passed");

            }else {
                System.out.println("Test Failed");
            }
        }
    }
}
