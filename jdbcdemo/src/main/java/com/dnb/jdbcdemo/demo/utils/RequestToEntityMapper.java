package com.dnb.jdbcdemo.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dnb.jdbcdemo.demo.dto.Account;
import com.dnb.jdbcdemo.payload.request.AccountRequest;
@Component
public class RequestToEntityMapper {
	// entity.class and request.class ----> entity obj
public Account getAccountEntityObject(AccountRequest accountRequest) {
	Account account = new Account();
	account.setAccountHolderName("Sathwik");
	account.setAccountType(accountRequest.getAccountType());
	account.setAddress(accountRequest.getAddress());
	account.setBalance(accountRequest.getBalance());
	account.setContactNumber(accountRequest.getContactNumber());
	account.setDob(accountRequest.getDob());
	account.setCustomerId(accountRequest.getCustomerId());
	return account;
}
}
