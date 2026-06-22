package com.java.backend.week1advancedjavaandcorefoundations.bankingtransactionprocessor2;
import java.sql.SQLException;
public class AccountRepository2 {
    public double getAccountBalance(String accountId)throws DataAccessException2 {
        try{
            simulateDatabaseCall();
            return 5000.0;
        }catch (SQLException e){
            throw new DataAccessException2("Failed to retrieve account balance for account " +accountId,e);
        }

    }
    private void simulateDatabaseCall()throws SQLException{
        throw new SQLException("Database connection lost");
    }
}
