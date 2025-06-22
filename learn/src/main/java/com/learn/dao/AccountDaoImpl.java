package com.learn.dao;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountDaoImpl implements AccountDao{
    @Override
    public void addAccount(String name) {
        System.out.println("Adding account..."+name);
    }

    @Override
    public List<String> retrieveAccounts() {
        return List.of("misr","qnb","cib");
    }
}
