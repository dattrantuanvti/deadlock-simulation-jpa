package com.tagapi.tagapi.controller;

import com.tagapi.tagapi.service.impl.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

  private final AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping("/deadlock")
  public String triggerDeadlock(@RequestParam Long idA, @RequestParam Long idB,
      @RequestParam Double amount) {

    // Mô phỏng 2 luồng cùng chạy 1 lúc
    Thread thread1 = new Thread(() -> accountService.transferAtoB(idA, idB, amount));
    Thread thread2 = new Thread(() -> accountService.transferBtoA(idB, idA, amount));

    thread1.start();
    thread2.start();

    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    return "Deadlock simulation completed";
  }
}
