package com.dnb.jdbcdemo1.service;

import com.dnb.jdbcdemo1.dto.Account;
import com.dnb.jdbcdemo1.repo.AccountRepository;
import com.dnb.jdbcdemo1.repo.AccountRepositoryImpl;

import java.util.List;
import java.util.Optional;


public class AccountServiceImpl implements AccountService {

	private AccountServiceImpl(){

    }

    private static AccountService accountService = null;

    public static AccountService getInstance(){

        synchronized (AccountServiceImpl.class){
            if(accountService == null) {
                accountService = new AccountServiceImpl();
            }
        }

        return accountService;
    }

    @Override
    public Account createAccount(Account account) {
        AccountRepository accountRepository = AccountRepositoryImpl.getInstance();
        return accountRepository.createAccount(account);
    }
    
    @Override
    public Optional<Account> getAccountById(String accountId) {
        AccountRepository accountRepository = AccountRepositoryImpl.getInstance();
        return  accountRepository.getAccountById(accountId);
    }
    @Override
     public boolean deleteAccount(String accountId)
     {
    	 AccountRepository accountRepository = AccountRepositoryImpl.getInstance();
         return  accountRepository.deleteAccount(accountId);
    	 
     }
    
     @Override
     public List<Account> getAllAccounts()
     {
    	 AccountRepository accountRepository = AccountRepositoryImpl.getInstance();
         return  accountRepository.getAllAccounts();
    	 
     }

}
