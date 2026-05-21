package com.example.demo.repo;

import com.example.demo.model.Account;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AccountRepository {

    private final Map<Long, Account> accounts = new ConcurrentHashMap<>();

    public Account get(Long id) {
        return accounts.get(id);
    }

    public void createAccount(Long id, double balance) {
        accounts.put(id, new Account(id, balance));
    }

    public Collection<Account> getAll() {
        return accounts.values();
    }
}