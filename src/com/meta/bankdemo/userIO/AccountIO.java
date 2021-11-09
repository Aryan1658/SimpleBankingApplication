package com.meta.bankdemo.userIO;

import com.meta.bankdemo.model.Account;

public class AccountIO extends  BaseIO{

    public Account readAccount(){
        Account account = new Account();
        account.setCustomerId(Integer.parseInt(read("Customer Id")));
        account.setAccountType(read("Account Type"));
        return account;
    }
}
