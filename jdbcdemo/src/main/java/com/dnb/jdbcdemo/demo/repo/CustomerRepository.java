package com.dnb.jdbcdemo.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.jdbcdemo.demo.dto.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	 public Customer createCustomer(Customer customer);
	    public Optional<Customer> getCustomerById(int i);

	    public boolean deleteCustomer(int customerId);
	    public boolean updateCustomer(int customerId);

	    public List<Customer> getAllCustomer();
	    public List<Customer> findBycustomerContactNumber(String customerContactNumber);
}
