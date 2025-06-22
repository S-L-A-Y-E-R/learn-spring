package com.learn.dao;

import java.util.List;

public interface AccountDao {
    void addAccount(String name);

    List<String> retrieveAccounts();
}
