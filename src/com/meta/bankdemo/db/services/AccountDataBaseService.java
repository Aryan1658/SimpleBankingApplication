package com.meta.bankdemo.db.services;

import com.meta.bankdemo.db.DBConnection;
import com.meta.bankdemo.model.Account;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Locale;
import java.util.UUID;

public class AccountDataBaseService {
    DBConnection dbConnection = new DBConnection();

    public boolean createCustomerAccount(Account account) {
        try {
            String insertAccountSQL = "insert into tbl_account (account_number, account_open_date, account_closed_date, primary_balance, interest_accured,\n" +
                    "                         total_balance, account_type, tbl_customer_id)\n" +
                    "values (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = dbConnection.connection.prepareStatement(insertAccountSQL);
            preparedStatement.setString(1, UUID.randomUUID().toString().substring(0, 9).toUpperCase(Locale.ROOT).replace("-","0"));
            preparedStatement.setDate(2, new Date(new java.util.Date().getTime()));
            preparedStatement.setDate(3, null);
            preparedStatement.setDouble(4, 0.00);
            preparedStatement.setDouble(5, 0.00);
            preparedStatement.setDouble(6, 0.00);
            preparedStatement.setString(7, account.getAccountType());
            preparedStatement.setInt(8, account.getCustomerId());
            int result = preparedStatement.executeUpdate();
            return result > 0 ? true : false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }


    }

}
