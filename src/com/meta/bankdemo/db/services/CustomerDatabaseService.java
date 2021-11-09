package com.meta.bankdemo.db.services;

import com.meta.bankdemo.db.DBConnection;
import com.meta.bankdemo.model.Customer;
import com.meta.bankdemo.utils.DateTimeUtils;

import java.sql.PreparedStatement;

public class CustomerDatabaseService {
    DBConnection dbConnection = new DBConnection();

    public int createCustomer(Customer customer) {
        try {
            String insertSQL = "insert into tbl_customer (full_name, mobile_number," +
                    "email_address,is_premium," +
                    "date_of_birth,id_type,id_number)\n" +
                    "values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = dbConnection.connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, customer.getFullName());
            preparedStatement.setString(2, customer.getMobileNumber());
            preparedStatement.setString(3, customer.getEmailAddress());
            preparedStatement.setBoolean(4, customer.isPremium());
            preparedStatement.setDate(5, DateTimeUtils.convertToDate(customer.getDateOfBirth()));
            preparedStatement.setString(6, customer.getIdType());
            preparedStatement.setString(7, customer.getIdName());
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
            }
            return 1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

}
