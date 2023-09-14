package com.dnb.jdbcdemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.jdbcdemo.demo.dto.Account;
import com.dnb.jdbcdemo.demo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.demo.exceptions.InvalidAccTypeException;
import com.dnb.jdbcdemo.demo.exceptions.InvalidContactException;
import com.dnb.jdbcdemo.demo.exceptions.InvalidNameException;
import com.dnb.jdbcdemo.demo.services.AccountService;
import com.dnb.jdbcdemo.demo.utils.RequestToEntityMapper;
import com.dnb.jdbcdemo.payload.request.AccountRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/account")
public class AccountController {
@Autowired
AccountService accountService;
@Autowired
RequestToEntityMapper entityMapper;
@PostMapping("/create")
public ResponseEntity<?> createAccount1(@Valid @RequestBody AccountRequest account) throws IdNotFoundException{
	
	return ResponseEntity.ok(accountService.createAccount(entityMapper.getAccountEntityObject(account)));
}

@DeleteMapping("/{accountId}")
public ResponseEntity<?> deleteAccountById
(@PathVariable("accountId") String accountId) throws IdNotFoundException{
	if(accountService.existsornot(accountId)) {
		accountService.deleteAccount(accountId);
		return ResponseEntity.ok("Deleted");
	}
	else {
		throw new IdNotFoundException("ID is not valid");
	}
}

@GetMapping("/cn/{contactNumber}")
public ResponseEntity<?> getAccountByContact
(@PathVariable("contactNumber") String contactNumber) throws InvalidContactException{
	List<Account> optional = accountService.findAllContact(contactNumber);
	return ResponseEntity.ok(optional);




}



@GetMapping("/{accountId}")
public ResponseEntity<?> getAccountById
(@PathVariable("accountId") String accountId) throws IdNotFoundException {
	Optional<Account> optional = accountService.getAccountById(accountId);
	if(optional.isPresent()) {
		return ResponseEntity.ok(optional.get());
	}
	else {
		//to form JSON object in java best to work with map
//		Map<String , String> map = new HashMap<>();
//		map.put("Message", "ID Not Found");
//		map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
//		ResponseEntity<?> responseEntity = new ResponseEntity(map,HttpStatus.NOT_FOUND);
//		return responseEntity;
		//return ResponseEntity.notFound().build();
		throw new IdNotFoundException("Id not valid");
	}
}
//@PostMapping("/create")
//@Valid AccountRequest createAccount(@Valid @RequestBody AccountRequest account) {
////	try {
////		//without valid here it directly hits DB and returns errors.
////		Account account2 = accountService.createAccount(account);
////		return new ResponseEntity(account2,HttpStatus.CREATED );
////	} catch (IdNotFoundException e) {
////		// TODO Auto-generated catch block
////		return ResponseEntity.badRequest().body(e.getMessage());
////	}
//	//if success status code is 200 but expected is 201
//	return account;
//}

}
