package com.learn.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDaoImpl implements AccountDao{
    @Override
    public void addAccount() {
        System.out.println("Adding account...");
    }
}
