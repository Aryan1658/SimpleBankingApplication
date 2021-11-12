package com.meta.bankdemo.db.services;

import com.meta.bankdemo.db.DBConnection;
import com.meta.bankdemo.model.Customer;
import com.meta.bankdemo.userIO.BaseIO;
import com.meta.bankdemo.utils.DateTimeUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class CustomerDatabaseService extends BaseIO {
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

    public List<Customer> findAllCustomer(){
        List<Customer> customerList = new ArrayList<>();

        try{
            String selectAllCustomerSQL = "select id,full_name,mobile_number,email_address,is_premium,date_of_birth\n" +
                    "from tbl_customer";
            PreparedStatement preparedStatement = dbConnection.connection.prepareStatement(selectAllCustomerSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String fullName = resultSet.getString("full_name");
                String mobile_number = resultSet.getString("mobile_number");
                String emailAddress = resultSet.getString("email_address");
                Boolean is_premium = resultSet.getBoolean("is_premium");
                Date dateOfBirth = resultSet.getDate("date_of_birth");

                Customer customer = new Customer(id,
                        fullName,mobile_number,
                        emailAddress,
                        is_premium,
                        DateTimeUtils.convertDateToString(dateOfBirth));
                customerList.add(customer);

            }
        }catch(Exception ex){
            display(ex.getMessage());
        }
            return customerList;
    }
}
