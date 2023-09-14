package com.dnb.jdbcdemo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dnb.jdbcdemo.demo.dto.Account;
import com.dnb.jdbcdemo.demo.dto.Customer;
import com.dnb.jdbcdemo.demo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.demo.exceptions.InvalidAccTypeException;
import com.dnb.jdbcdemo.demo.exceptions.InvalidContactException;
import com.dnb.jdbcdemo.demo.exceptions.InvalidDateException;
import com.dnb.jdbcdemo.demo.exceptions.InvalidNameException;
import com.dnb.jdbcdemo.demo.services.AccountService;
import com.dnb.jdbcdemo.demo.services.CustomerService;

@SpringBootApplication
public class JdbcdemoApplication {
//	static Scanner sc = new Scanner(System.in);
//	private static AccountService accountService;
//	private static CustomerService customerService;
	
	public static void main(String[] args) {
		ApplicationContext applicationcontext=SpringApplication.run(JdbcdemoApplication.class, args);

	}
}
//		Account account2=null;
//		int choice=0;
//		ApplicationContext applicationContext = SpringApplication.run(JdbcdemoApplication.class, args);
//        accountService = applicationContext.getBean(AccountService.class);
//        customerService = applicationContext.getBean(CustomerService.class);
//        applicationContext.getBean(AccountService.class).getAllAccount().forEach(account -> { System.out.println
//        	(account.getAccountId() + " " + account.getAccountHolderName() + " " + account.getAccountType() + " " +
//               account.getBalance() + " " + account.getAccountCreatedDate() + " " + account.getDob() + " " );
//        });
       
//        Optional<Account> result = accountService.getAccountById("sad");
//        if (result.isPresent()) {
//          Account account = result.get();
//          System.out.println(account.getAccountId() + " " + account.getAccountHolderName() + " " + account.getAccountType() + " " +
//                  account.getBalance() + " " + account.getAccountCreatedDate() + " " + account.getDob() + " " + account.isAccountStatus());
//        }
//        boolean deleteAcc = accountService.deleteAccount("sad");
//        System.out.println(deleteAcc);
//      } else {
//          System.out.println("No account found for this " + accountId + " account id.");
//      }

//      
//
//        do {
//        	System.out.println(LocalDate.of(2001, 10, 26));
//            System.out.println("Enter your choice :\n" +
//                    "1. Create Account \n" +
//                    "2. Search Account By ID\n" +
//                    "3. Delete Account \n" +
//                    "4. Get All Account \n" +
//                    "5.Create Customer \n"+
//                    "6.Search Customer\n"+
//                    "7. Delete Customer \n"+
//                    "8. Get All Customer \n"+
//                    "9. Exit");
//            choice = sc.nextInt();
//
//            if (choice < 1 || choice > 5) {
//                System.out.println("Enter correct choice");
//                continue;
//            }
//
//            switch (choice) {
//                case 1 -> createAccount();
//                case 2 -> getAccount(sc.next());
//                case 3 -> deleteAccount(sc.next());
//                case 4 -> getAllAccount();
//                case 5 -> createCustomer();
//                case 6 -> getCustomer(sc.nextInt());
//                case 7 -> deleteCustomer(sc.nextInt());
//                case 8 -> getAllCustomer();
//                case 9 -> {
//                }
//            }
//
//        } while (choice != 9);
//
//
//    }
//	
//	private static Iterable<Customer> getAllCustomer() {
//		
//		return customerService.getAllCustomer();
//	}
//
//	private static Iterable<Account> getAllAccount() throws InvalidNameException, InvalidContactException, IdNotFoundException, InvalidAccTypeException {
//	
//		return accountService.getAllAccount();
//	}
//
//	private static boolean deleteCustomer(int customerId) throws IdNotFoundException {
//		// TODO Auto-generated method stub
//		return customerService.deleteCustomer(customerId);
//	}
//
//	private static boolean deleteAccount(String accountId) throws IdNotFoundException {
//		// TODO Auto-generated method stub
//		return accountService.deleteAccount(accountId);
//	}
//
//	private static Optional<Customer> getCustomer(int CustomerId) {
//		// TODO Auto-generated method stub
//		return customerService.getCustomerById(CustomerId);
//	}
//
//	private static Optional<Account> getAccount(String accountId) throws InvalidNameException, InvalidContactException, IdNotFoundException, InvalidAccTypeException {
//		// TODO Auto-generated method stub
//		return accountService.getAccountById(accountId);
//	}
//
//	private static void createAccount() {
//		// TODO Auto-generated method stub
//		System.out.println("Enter the account details to create :");
//        try {
//		
//			Account account2 = new Account( sc.next(), sc.next(), sc.nextFloat(), sc.next(),sc.next(),LocalDate.now(), LocalDate.of(2001, 10, 22), true);
//			accountService.createAccount(account2);
//        }
//        catch(IdNotFoundException e) {
//        	e.printStackTrace();
//        } 
//	} 
//
//    public static void  createCustomer() {
//    	System.out.println("Enter Customer details: ");
//   
//    	Customer customer2 = new Customer(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
//    	customerService.createCustomer(customer2);
//    	
   // } 



//}
