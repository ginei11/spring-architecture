package com.example.account.service;

import com.example.account.model.entity.Account;
import com.example.account.model.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImp implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public List<Account> findAll() {
        return (List<Account>)accountRepository.findAll();
    }

    @Override
    public Account findById(Integer id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }
}
