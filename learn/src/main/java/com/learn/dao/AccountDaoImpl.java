package com.learn.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDaoImpl implements AccountDao{
    @Override
    public void addAccount(String name){
        System.out.println("Adding account..."+name);
        throw new RuntimeException("Error adding an account");
    }

    @Override
    public void retrieveAccounts() {
    }
}
