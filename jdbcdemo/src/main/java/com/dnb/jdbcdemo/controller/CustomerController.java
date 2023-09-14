package com.dnb.jdbcdemo.controller;

import java.util.List;

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
import com.dnb.jdbcdemo.demo.dto.Customer;
import com.dnb.jdbcdemo.demo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.demo.exceptions.InvalidContactException;
import com.dnb.jdbcdemo.demo.services.AccountService;
import com.dnb.jdbcdemo.demo.services.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/create")
	//request body will convert json to java
	ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer) throws IdNotFoundException {
		//without valid here it directly hits DB and returns errors.
		Customer customer2 = customerService.createCustomer(customer);
		return new ResponseEntity(customer2,HttpStatus.CREATED );
	}
	
	@GetMapping("/cn/{contactNumber}")
	public ResponseEntity<?> getCustomerByContact
	(@PathVariable("customerContactNumber") String contactNumber) throws InvalidContactException{
		List<Account> optional = customerService.findAllContact(contactNumber);
		return ResponseEntity.ok(optional);




	}
//	@DeleteMapping("/{customerId}")
//	public ResponseEntity<?> deleteCustomerById
//	(@PathVariable("customerId") String customerId) throws IdNotFoundException{
//		if(customerService.existsornot(customerId)) {
//			customerService.deleteCustomer(customerId);
//			return ResponseEntity.ok("Deleted");
//		}
//		else {
//			throw new IdNotFoundException("ID is not valid");
//		}
//	}
	
}
