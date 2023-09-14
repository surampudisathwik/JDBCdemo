package com.dnb.jdbcdemo1;

import com.dnb.jdbcdemo1.config.Config;
import com.dnb.jdbcdemo1.dto.Account;
import com.dnb.jdbcdemo1.repo.AccountRepository;
import com.dnb.jdbcdemo1.service.AccountService;
import com.dnb.jdbcdemo1.service.AccountServiceImpl;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JDBCApplication {
//	private static AccountService accountService
	
    public static void main(String[] args) {
    	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        AccountService accountService = applicationContext.getBean("accountServiceImpl",AccountService.class);
        System.out.println(accountService!=null);
    	Scanner sc= new Scanner(System.in);
    	int choice;
    	do {
    	System.out.println("Choose the option :");
    	System.out.println("1.Create an account");
    	System.out.println("2.Return the account by id");
    	System.out.println("3.Delete the record");
    	System.out.println("4.Get all accounts");
    	System.out.println("5.Exit!");
    	choice = sc.nextInt();
    	switch(choice)
    	{
    	case 1:
    		
        Account account = new Account();
        
        
        System.out.println("Enter acc id: ");  account.setAccountId(sc.next());
        System.out.println("Enetr name :");  account.setAccountHolderName(sc.next());
        System.out.println("Acc type: "); account.setAccountType(sc.next());
        System.out.println("Balance: "); account.setBalance(sc.nextFloat());
        System.out.println("Contact: "); account.setContactNumber(sc.next());
        System.out.println("Address: "); account.setAddress(sc.next());
        System.out.println("Date :"); String date = sc.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dob = LocalDate.parse(date,formatter);
        account.setDob(dob);
        account.setAccountStatus(true);
        accountService.createAccount(account);
    	
    	break;
    	case 2:
    		System.out.println("Enter the account Id");
    		String accountId = sc.next();
    		Optional<Account> result = accountService.getAccountById(accountId);

    		if (result.isPresent()) {
    		Account account1 = result.get();
    		System.out.println(account1.getAccountId() + " " + account1.getAccountHolderName() + " " + account1.getAccountType() + " " +
    		account1.getBalance() + " " + account1.getAccountCreatedDate() + " " + account1.getDob() + " " + account1.isAccountStatus());
    		}else{
    		System.out.println("No account found for this " + accountId + " account id.");
    		}
    		break;
    	case 3:
    		System.out.println("Enter the account Id");
    		String accountId1 = sc.next();
    		boolean ans = accountService.deleteAccount(accountId1);
    		System.out.println(ans);
    		break;
    	case 4:
    		List<Account> la = accountService.getAllAccounts();
    		for(Account ex:la)
    		{
    			System.out.println(ex.getAccountId()+" "+ ex.getDob());
    		}
    		break;
    	}
}while(choice!=5);
    }
}
