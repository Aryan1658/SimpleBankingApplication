package com.meta.bankdemo.service.impl;

import com.meta.bankdemo.db.services.CustomerDatabaseService;
import com.meta.bankdemo.model.Customer;
import com.meta.bankdemo.service.GenericService;

import java.util.List;

public class CustomerServiceImpl extends  CustomerDatabaseService implements GenericService<Customer>, CustomerService {


    @Override
    public boolean create(Customer customer) {
        return false;
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    @Override
    public List<Customer> findAll() {
        return findAllCustomer();
    }

    @Override
    public Customer findCustomerByMobileNumber(String mobileNumber) {
        return null;
    }
}

