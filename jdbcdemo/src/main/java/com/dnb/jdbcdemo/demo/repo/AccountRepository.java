package com.dnb.jdbcdemo.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.jdbcdemo.demo.dto.Account;
import com.dnb.jdbcdemo.demo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.demo.exceptions.InvalidAccTypeException;
import com.dnb.jdbcdemo.demo.exceptions.InvalidContactException;
import com.dnb.jdbcdemo.demo.exceptions.InvalidNameException;
@Repository
public interface AccountRepository extends CrudRepository<Account, String> {
//    public Account createAccount(Account account);
//    public Optional<Account> getAccountById(String accountId) throws InvalidNameException, InvalidContactException, IdNotFoundException, InvalidAccTypeException;
//
//    public boolean deleteAccount(String accountId);
//    public boolean updateAccount(String accountId);
//
//    public List<Account> getAllAccount() throws InvalidNameException, InvalidContactException, IdNotFoundException, InvalidAccTypeException;
	//public Optional<Account>  findByContactNumber(String contactNumber);
	public List<Account> findByContactNumber(String contactNumber);
}
