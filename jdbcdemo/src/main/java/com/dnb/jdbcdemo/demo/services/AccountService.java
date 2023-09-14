package com.dnb.jdbcdemo.demo.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dnb.jdbcdemo.demo.dto.Account;
import com.dnb.jdbcdemo.demo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.demo.exceptions.InvalidAccTypeException;
import com.dnb.jdbcdemo.demo.exceptions.InvalidContactException;
import com.dnb.jdbcdemo.demo.exceptions.InvalidNameException;

public interface AccountService {
   public Account createAccount(Account account) throws IdNotFoundException;
    public Optional<Account> getAccountById(String accountId); //throws InvalidNameException, InvalidContactException, IdNotFoundException, InvalidAccTypeException;
    public boolean deleteAccount(String accountId) throws IdNotFoundException;
    public boolean updateAccount(String accountId);
    public Iterable<Account> getAllAccount() throws InvalidNameException, InvalidContactException, IdNotFoundException, InvalidAccTypeException;
    public boolean existsornot(String accountId);
   // public Optional<Account>  findByContact(String contactNumber);
    public List<Account> findAllContact(String contactNumber); 
}
