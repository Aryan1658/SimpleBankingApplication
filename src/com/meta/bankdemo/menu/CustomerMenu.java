package com.meta.bankdemo.menu;

import com.meta.bankdemo.db.services.CustomerDatabaseService;
import com.meta.bankdemo.model.Customer;
import com.meta.bankdemo.userIO.BaseIO;
import com.meta.bankdemo.userIO.CustomerIO;

public class CustomerMenu extends CustomerIO {

    public CustomerMenu() {
        display("********** Welcome to Customer Section *********");
        CustomerDatabaseService customerDatabaseService = new CustomerDatabaseService();
        boolean status = true;
        while (status) {
            display("1 Customer Create");
            display("2 Customer Update");
            display("3 Customer List");
            display("4 Exit");
            int choice = Integer.parseInt(readChoice("Enter your choice"));
            switch (choice) {
                case 1:
                    display("Customer create section");
                    Customer customer = readCustomerInformation();

                    if (customer != null) {
                        int result = customerDatabaseService.createCustomer(customer);
                        display(result == 1 ? "Customer created successfully." : "Customer creation failed");

                    } else
                        display("Error occurred while reading customer");
                    break;
                case 2:
                    display("Customer update section");
                    break;
                case 3:
                    display("Customer list section");
                    break;
                case 4:
                    status = false;
                    display("********** Thanks for using Simple Bank's Customer Section *********");
                    break;
                default:
                    display("Invalid choice try again !!!");

            }
        }
    }

}
