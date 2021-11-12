package com.meta.bankdemo.menu;

import com.meta.bankdemo.userIO.BaseIO;

public class Menu extends BaseIO {

    public Menu() {
        display("********** Welcome to Simple Application *********");
        boolean status = true;
        while (status) {
            display("1 Customer Section");
            display("2 Account Section");
            display("3 Transaction Section");
            display("4 Exit");
            int choice = Integer.parseInt(readChoice("Enter your choice"));
            switch (choice) {
                case 1:
                    new CustomerMenu();
                    break;
                case 2:
                    new AccountMenu();
                    break;
                case 3:
                    new TransactionMenu();
                    break;
                case 4:
                    status = false;
                    display("********** Thanks for using Simple Application *********");
                    break;
                default:
                    display("Invalid choice try again !!!");

            }
        }
    }
}
