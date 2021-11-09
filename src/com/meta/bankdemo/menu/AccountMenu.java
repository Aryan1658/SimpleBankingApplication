package com.meta.bankdemo.menu;

import com.meta.bankdemo.db.services.AccountDataBaseService;
import com.meta.bankdemo.db.services.CustomerDatabaseService;
import com.meta.bankdemo.model.Account;
import com.meta.bankdemo.userIO.AccountIO;

public class AccountMenu extends AccountIO {

    AccountDataBaseService accountDataBaseService = new AccountDataBaseService();

    public AccountMenu() {

        display("********** Welcome to Account Section *********");
        boolean status = true;
        while (status) {
            display("1 Account Create");
            display("2 Exit");
            int choice = Integer.parseInt(readChoice("Enter your choice"));
            switch (choice) {
                case 1:
                    //Account create
                    Account account = readAccount();
                    if (accountDataBaseService.createCustomerAccount(account)){
                        display("Account created successfully.");
                    }else {
                        display("Account creation failed.");
                    }
                    break;
                case 2:
                    status = false;
                    display("********** Thanks for using Simple Bank's Account Section *********");
                    break;
                default:
                    display("Invalid input please try again !!!");

            }
        }
    }
}
