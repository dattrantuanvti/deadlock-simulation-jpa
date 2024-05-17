package com.tagapi.tagapi.service.impl;

import com.tagapi.tagapi.model.Account;
import com.tagapi.tagapi.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

  private final AccountRepository accountRepository;

  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Transactional
  public void transferAtoB(Long idA, Long idB, Double amount) {
    Account accountA = accountRepository.findById(idA).orElseThrow();
    accountA.setBalance(accountA.getBalance() - amount);
    accountRepository.save(accountA);

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    Account accountB = accountRepository.findById(idB).orElseThrow();
    accountB.setBalance(accountB.getBalance() + amount);
    accountRepository.save(accountB);
  }

  @Transactional
  public void transferBtoA(Long idB, Long idA, Double amount) {
    Account accountB = accountRepository.findById(idB).orElseThrow();
    accountB.setBalance(accountB.getBalance() - amount);
    accountRepository.save(accountB);

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    Account accountA = accountRepository.findById(idA).orElseThrow();
    accountA.setBalance(accountA.getBalance() + amount);
    accountRepository.save(accountA);
  }
}
