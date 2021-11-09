package com.meta.bankdemo.service.impl;

import com.meta.bankdemo.model.Customer;

public interface CustomerService {

    Customer findCustomerByMobileNumber(String mobileNumber);

}

