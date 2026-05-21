package com.example.demo.service;

import com.example.demo.repo.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransferServiceTest {

    private AccountRepository repo;
    private TransferService service;

    @BeforeEach
    void setup() {
        repo = new AccountRepository();
        repo.createAccount(1L, 1000.0);
        repo.createAccount(2L, 500.0);

        service = new TransferService(repo);
    }

    @Test
    void testSuccessfulTransfer() {
        service.transfer(1L, 2L, 100);

        assertEquals(900.0, repo.get(1L).getBalance());
        assertEquals(600.0, repo.get(2L).getBalance());
    }

    @Test
    void testInsufficientFunds() {
        Exception ex = assertThrows(RuntimeException.class, () -> {
            service.transfer(1L, 2L, 2000);
        });

        assertEquals("Insufficient funds", ex.getMessage());
    }

    @Test
    void testInvalidAccount() {
        Exception ex = assertThrows(RuntimeException.class, () -> {
            service.transfer(1L, 99L, 100);
        });

        assertEquals("Account not found", ex.getMessage());
    }

    @Test
    void testNegativeAmount() {
        Exception ex = assertThrows(RuntimeException.class, () -> {
            service.transfer(1L, 2L, -10);
        });

        assertEquals("Invalid amount", ex.getMessage());
    }
}