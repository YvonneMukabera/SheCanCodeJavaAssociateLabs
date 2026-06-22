package com.java.backend.week1advancedjavaandcorefoundations.bankingtransactionprocessor2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class LoggerDemo2 {
private static final Logger logger= LoggerFactory.getLogger(LoggerDemo2.class);
public static void main(String[] args) {
    MDC.put("transactionId", "TX-1001");
    AccountRepository2 accountRepository = new AccountRepository2();
    try{
        accountRepository.getAccountBalance("ACCO01");
    }catch (DataAccessException2 e){
        logger.error("Balance lookup failed",e);
    }
    MDC.clear();
}
}
