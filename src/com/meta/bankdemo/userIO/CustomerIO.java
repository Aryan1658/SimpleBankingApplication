package com.meta.bankdemo.userIO;

import com.meta.bankdemo.model.Customer;

import java.util.List;

/*
 * This class is basically for reading and displaying customer
 * While reading it must return the thing that it reads
 * while displaying it should return void
 * */
public class CustomerIO extends BaseIO {

    public Customer readCustomerInformation() {
        Customer customer = new Customer();
        try {
            customer.setFullName(read("Full Name"));
            customer.setMobileNumber(read("mobile number"));
            customer.setEmailAddress(read("email address"));
            customer.setDateOfBirth(read("date of birth in pattern (yyyy-mm-dd)"));
            customer.setPremium(Boolean.parseBoolean(read("premium [True or False]")));
            customer.setIdType(read("id type "));
            customer.setIdName(read("id number"));
        } catch (Exception ex) {
            ex.printStackTrace();
            display(ex.getMessage());
            return null;
        }
        return customer;
    }

    public void displayCustomerList(List<Customer> customerList) {

        customerList.stream().forEach(customer -> displayCustomerInformation(customer));
    }

    public void displayCustomerInformation(Customer customer) {
        display("------------------------------------");
        display("ID\t" + customer.getId());
        display("NAME\t" + customer.getFullName());
        display("MOBILE\t" + customer.getMobileNumber());
        display("EMAIL\t" + customer.getEmailAddress());
        display("IS PREMIUM\t" + customer.isPremium());
        display("DOB\t" + customer.getDateOfBirth());
        display("------------------------------------");

    }
}
