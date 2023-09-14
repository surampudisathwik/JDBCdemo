package com.dnb.jdbcdemo.demo.services;

import java.util.List;
import java.util.Optional;

import com.dnb.jdbcdemo.demo.dto.Account;
import com.dnb.jdbcdemo.demo.dto.Customer;
import com.dnb.jdbcdemo.demo.exceptions.IdNotFoundException;

public interface CustomerService {
	 public Customer createCustomer(Customer customer);
	    public Optional<Customer> getCustomerById(int customerId);
	    public boolean deleteCustomer(int customerId) throws IdNotFoundException;
	    public boolean updateCustomer(int customerId);
	    public Iterable<Customer> getAllCustomer();
	    public List<Customer> findAllContact(String contactNumber); 

}
