package com.meta.bankdemo.db.services;

import com.meta.bankdemo.db.DBConnection;
import com.mysql.cj.xdevapi.PreparableStatement;

import java.sql.PreparedStatement;

public class TransactionDataBaseServices {
    DBConnection dbConnection = new DBConnection();
    public void createTransactionLog(Integer accountId,
                              Integer transactionTypeId,
                              Double amount,
                              String status)
    {
        try{
            String transactionLogSQL = "insert into tbl_account_transcations\n" +
                    "(tbl_account_id,transaction_type_id,\n" +
                    " amount,status)\n" +
                    "values (?,?,?,?)";
            PreparedStatement preparedStatement = dbConnection.connection.prepareStatement(transactionLogSQL);
        preparedStatement.setInt(1,accountId);
        preparedStatement.setInt(2,transactionTypeId);
        preparedStatement.setDouble(3,amount);
        preparedStatement.setString(4,status);
        preparedStatement.executeUpdate();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
