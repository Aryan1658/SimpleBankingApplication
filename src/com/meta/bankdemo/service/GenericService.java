package com.meta.bankdemo.service;

import com.meta.bankdemo.menu.CustomerMenu;
import com.meta.bankdemo.model.Customer;

import java.util.List;

public interface GenericService<T> {

    boolean create(T t);

    boolean update(T t);

    List<T> findAll();


}
