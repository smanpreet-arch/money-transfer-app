package com.example.demo.controller;

import com.example.demo.dto.TransferRequest;
import com.example.demo.model.Account;
import com.example.demo.repo.AccountRepository;
import com.example.demo.service.TransferService;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/api")
public class TransferController {

    private final TransferService service;
    private final AccountRepository repo;

    public TransferController(TransferService service, AccountRepository repo) {
        this.service = service;
        this.repo = repo;
    }

    @PostMapping("/transfer")
    public String transfer(@RequestBody TransferRequest request) {
        service.transfer(
                request.getFromAccountId(),
                request.getToAccountId(),
                request.getAmount()
        );
        return "Transfer was successful";
    }

    @GetMapping("/accounts")
    public Collection<Account> getAccounts() {
        return repo.getAll();
    }
}