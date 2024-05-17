package com.tagapi.tagapi.repository;

import com.tagapi.tagapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
