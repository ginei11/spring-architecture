package com.example.account.service;

import com.example.account.model.entity.Account;

import java.util.List;

public interface IAccountService {
    public List<Account> findAll();
    public Account findById(Integer id);
    public  Account save(Account account);
}
