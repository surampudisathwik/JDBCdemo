package com.dnb.jdbcdemo.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.jdbcdemo.demo.dto.Account;
import com.dnb.jdbcdemo.demo.dto.Customer;
import com.dnb.jdbcdemo.demo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.demo.exceptions.InvalidAccTypeException;
import com.dnb.jdbcdemo.demo.exceptions.InvalidContactException;
import com.dnb.jdbcdemo.demo.exceptions.InvalidNameException;
import com.dnb.jdbcdemo.demo.repo.AccountRepository;
import com.dnb.jdbcdemo.demo.repo.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepository accountRepository;
	@Override
	public Account createAccount(Account account) throws IdNotFoundException {
		// TODO Auto-generated method stub
		accountRepository.save(account);
		return null;
	}

	@Override
	public Optional<Account> getAccountById(String accountId){
			//throws InvalidNameException, InvalidContactException, IdNotFoundException, InvalidAccTypeException {
		// TODO Auto-generated method stub
		return accountRepository.findById(accountId);
	}

	@Override
	public boolean deleteAccount(String accountId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(accountRepository.existsById(accountId))
		{
			 accountRepository.deleteById(accountId);
		}
		else throw new IdNotFoundException("Id Not Found!!");
		if(accountRepository.existsById(accountId)) return false;
		else return true;
		
	}

	@Override
	public boolean updateAccount(String accountId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Account> getAllAccount()
			throws InvalidNameException, InvalidContactException, IdNotFoundException, InvalidAccTypeException {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public boolean existsornot(String accountId) {
		if(accountRepository.existsById(accountId)) return true;
		else return false;
	}

//	@Override
//	public Optional<Account> findByContact(String contactNumber) {
//		
//		return accountRepository.findByContactNumber(contactNumber);
//	}

	@Override
	public List<Account> findAllContact(String contactNumber) {
		// TODO Auto-generated method stub
		return accountRepository.findByContactNumber(contactNumber);
	}

//    @Autowired
//    public AccountRepository accountRepository;
//    @Override
//    public Account createAccount(Account account)
//    {
//    	accountRepository.save(account);
//    }
//    @Autowired
//    private CustomerRepository customerRepository;

  

//    @Override
//    public Optional<Account> getAccountById(String accountId) {
//        return accountRepository.getAccountById(accountId);
//    }
//
//    @Override
//    public boolean deleteAccount(String accountId) {
//       // return accountRepository.deleteAccount(accountId);
//    	return false;
//    }
//
//    @Override
//    public boolean updateAccount(String accountId) {
//
//        return false;
//    }
//
//    @Override
//    public List<Account> getAllAccount() throws InvalidNameException, InvalidContactException, IdNotFoundException, InvalidAccTypeException {
//        //return accountRepository.getAllAccount();
//    	return null;
//    }
}
