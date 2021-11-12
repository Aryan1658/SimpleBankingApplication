package com.meta.bankdemo.db.services;

import com.meta.bankdemo.db.DBConnection;
import com.meta.bankdemo.model.TransactionType;
import com.meta.bankdemo.userIO.BaseIO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransactionTypeDateBaseService extends BaseIO {

    DBConnection dbConnection = new DBConnection();

    public TransactionType findTransactionTypeByCode(String code) {
        try {
            String SQL = "select * from tbl_master_transaction_type where code =?";
            PreparedStatement preparedStatement = dbConnection.connection.prepareStatement(SQL);
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new TransactionType(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));

            }
        } catch (Exception ex) {
            display(ex.getMessage());
        }
        return null;

    }
    public List<TransactionType> findAll(){
        List<TransactionType> transactionTypes = new ArrayList<>();
        try {
            String SQL = "select * from tbl_master_transaction_type order by name";
            PreparedStatement preparedStatement = dbConnection.connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                transactionTypes.add(new TransactionType(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
        } catch (Exception ex) {
            display(ex.getMessage());
        }
        return transactionTypes;

    }


}
