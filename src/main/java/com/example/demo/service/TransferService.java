package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repo.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    private final AccountRepository repo;

    public TransferService(AccountRepository repo) {
        this.repo = repo;
    }

    public synchronized void transfer(Long fromId, Long toId, double amount) {
        Account from = repo.get(fromId);
        Account to = repo.get(toId);

        if (from == null || to == null) {
            throw new RuntimeException("Account not found");
        }

        if (amount <= 0) {
            throw new RuntimeException("Invalid amount");
        }

        if (from.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
    
        //validation placeholder
    }
}
