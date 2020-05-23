package com.example.account.controller;

import com.example.account.model.entity.Account;
import com.example.account.service.IAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private IAccountService accountService;

    @GetMapping("listar")
    public List<Account> listar () {
        return (List<Account>)accountService.findAll();
    }
    @GetMapping("/var/{id}")
    public  Account detalle(@PathVariable Integer id){
        Account account = accountService.findById(id);
        return  account;
    }
}
