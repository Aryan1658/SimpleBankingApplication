package com.meta.bankdemo.db.services;

import com.meta.bankdemo.db.DBConnection;
import com.meta.bankdemo.model.Account;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public Account findByAccountNumber (String accountNumber){
        try{
            String accountByAccountNumberSQL = "select * from tbl_account where account_number = ?";
            PreparedStatement preparedStatement = dbConnection.connection.prepareStatement(accountByAccountNumberSQL);
            preparedStatement.setString(1,accountNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return new Account(
                        resultSet.getInt("id"),
                        resultSet.getString("account_number"),
                        resultSet.getString("account_open_date"),
                        resultSet.getString("account_closed_date"),
                        resultSet.getDouble("primary_balance"),
                        resultSet.getDouble("interest_accured"),
                        resultSet.getDouble("total_balance"),
                        resultSet.getString("account_type"),
                        resultSet.getInt("tbl_customer_id")
                );
            }

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return null;

    }
    public void deposit(double depositAmount, String accountNumber) {
        try{
            String depositSQL = "update tbl_account set primary_balance = primary_balance + ? where account_number = ?";
            PreparedStatement preparedStatement = dbConnection.connection.prepareStatement(depositSQL);
            preparedStatement.setDouble(1,depositAmount);
            preparedStatement.setString(2,accountNumber);
            preparedStatement.executeUpdate();
            System.out.println("-----------------------");
            System.out.println("Deposit is completed");
            System.out.println("-----------------------");

        }catch (Exception ex){
            System.out.println("-----------------------");
            System.out.println("Deposit failed !!!");
            System.out.println("-----------------------");


        }
    }
    public void withDraw(double withDrawAmount, String accountNumber) {
        try{
            String withDrawSQL = "update tbl_account set primary_balance = primary_balance - ? where account_number = ?";
            PreparedStatement preparedStatement = dbConnection.connection.prepareStatement(withDrawSQL);
            preparedStatement.setDouble(1,withDrawAmount);
            preparedStatement.setString(2,accountNumber);
            preparedStatement.executeUpdate();
            System.out.println("-----------------------");
            System.out.println("Withdraw is completed");
            System.out.println("-----------------------");

        }catch (Exception ex){
            System.out.println("-----------------------");
            System.out.println("Withdraw failed !!!");
            System.out.println("-----------------------");


        }
    }

}
