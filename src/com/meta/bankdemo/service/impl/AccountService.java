package com.meta.bankdemo.service.impl;

import com.meta.bankdemo.model.Account;

public interface AccountService {

    Account findAccountByAccountNumber(String accountNumber);

}
