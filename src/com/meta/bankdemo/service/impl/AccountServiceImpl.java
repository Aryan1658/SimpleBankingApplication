package com.meta.bankdemo.service.impl;

import com.meta.bankdemo.model.Account;
import com.meta.bankdemo.service.GenericService;

import java.util.List;

public class AccountServiceImpl implements GenericService<Account> {

    @Override
    public boolean create(Account account) {
        return false;
    }

    @Override
    public boolean update(Account account) {
        return false;
    }

    @Override
    public List<Account> findAll() {
        return null;
    }
}
