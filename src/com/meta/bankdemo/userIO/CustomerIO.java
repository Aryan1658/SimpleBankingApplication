package com.meta.bankdemo.userIO;

import com.meta.bankdemo.model.Customer;

/*
 * This class is basically for reading and displaying customer
 * While reading it must return the thing that it reads
 * while displaying it should return void
 * */
public class CustomerIO extends BaseIO {

    public Customer readCustomerInformation() {
        Customer customer = new Customer();
       try{
           customer.setFullName(read("Full Name"));
           customer.setMobileNumber(read("mobile number"));
           customer.setEmailAddress(read("email address"));
           customer.setDateOfBirth(read("date of birth in pattern (yyyy-mm-dd)"));
           customer.setPremium(Boolean.parseBoolean(read("premium [True or False]")));
           customer.setIdType(read("id type "));
           customer.setIdName(read("id name"));
       }catch (Exception ex){
          ex.printStackTrace();
          display(ex.getMessage());
           return null;
       }
       return customer;
    }


}
