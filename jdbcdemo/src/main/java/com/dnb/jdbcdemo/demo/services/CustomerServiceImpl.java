package com.dnb.jdbcdemo.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.jdbcdemo.demo.dto.Account;
import com.dnb.jdbcdemo.demo.dto.Customer;
import com.dnb.jdbcdemo.demo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.demo.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	 @Autowired
	    public CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public Optional<Customer> getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerId);
	}

	@Override
	public boolean deleteCustomer(int customerId) throws IdNotFoundException {
		if(customerRepository.existsById(customerId))
		{
			customerRepository.deleteById(customerId);
		}
		else throw new IdNotFoundException("Id Not Found!!");
		if(customerRepository.existsById(customerId)) return false;
		else return true;
	}

	@Override
	public boolean updateCustomer(int customerId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public List<Customer> findAllContact(String contactNumber) {
		return customerRepository.findBycustomerContactNumber(contactNumber);
	}

//	   	@Override
//	    public Customer createCustomer(Customer customer) {
//	        return customerRepository.createCustomer(customer);
//	    }
//
//	    @Override
//	    public Optional<Customer> getCustomerById(int customerId) {
//	        return customerRepository.getCustomerById(customerId);
//	    }
//
//	    @Override
//	    public boolean deleteCustomer(int  customerId) {
//	        return customerRepository.deleteCustomer(customerId);
//	    }
//
//	    @Override
//	    public boolean updateCustomer(int customerId) {
//
//	        return false;
//	    }
//
//	    @Override
//	    public List<Customer> getAllCustomer() {
//	        return customerRepository.getAllCustomer();
//	    }
}
