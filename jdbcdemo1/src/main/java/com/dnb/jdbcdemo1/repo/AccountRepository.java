package com.dnb.jdbcdemo1.repo;

import java.util.List;
import java.util.Optional;

import com.dnb.jdbcdemo1.dto.Account;

public interface AccountRepository {
public Account createAccount(Account account);

Optional<Account> getAccountById(String accountId);

public boolean deleteAccount(String accountId);

public List<Account> getAllAccounts();
}
