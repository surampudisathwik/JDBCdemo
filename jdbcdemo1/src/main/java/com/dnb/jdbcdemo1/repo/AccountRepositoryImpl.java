package com.dnb.jdbcdemo1.repo;

import com.dnb.jdbcdemo1.dto.Account;
import com.dnb.jdbcdemo1.utils.DBUtils;
import com.mysql.cj.xdevapi.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class AccountRepositoryImpl implements AccountRepository {

	private static AccountRepository accountRepository;
    private AccountRepositoryImpl(){

    }
    public static AccountRepository getInstance(){

        synchronized (AccountRepositoryImpl.class){
            if(accountRepository == null) {
                accountRepository = new AccountRepositoryImpl();
            }
        }

        return accountRepository;
    }
    	
    @Override
    public Account createAccount(Account account) {

        Optional<Connection> connection = DBUtils.getConnection();
        String createAccount = "insert into account"
                + "(accountId ,accountHolderName ,accountType ,balance ,contactNumber ,address ,accountCreatedDate ,dob, accountStatus)"
                + " values(?,?,?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = null;

        if(connection.isPresent()){
            try {
                preparedStatement = connection.get().prepareStatement(createAccount);

                preparedStatement.setString(1,account.getAccountId());
                preparedStatement.setString(2,account.getAccountHolderName());
                preparedStatement.setString(3,account.getAccountType());
                preparedStatement.setFloat(4,account.getBalance());
                preparedStatement.setString(5,account.getContactNumber());
                preparedStatement.setString(6,account.getAddress());
                preparedStatement.setDate(7, java.sql.Date.valueOf(account.getAccountCreatedDate()));
                preparedStatement.setDate(8, java.sql.Date.valueOf(account.getDob()));
                preparedStatement.setBoolean(9, account.isAccountStatus());

                int result = preparedStatement.executeUpdate();

                if(result > 0){
                    return account;
                }
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
            finally {
                if(connection.isPresent()){
                    DBUtils.closeConnection(connection.get());
                }
            }
        }

        return null;
    }

    public Optional<Account> getAccountById(String accountId) {
        Optional<Connection> connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select * from account where accountId = ?";

        if (connection.isPresent()) {
            try {
                preparedStatement = connection.get().prepareStatement(query);
                preparedStatement.setString(1, accountId);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()){
                    Account account = new Account();
                    account.setAccountId(resultSet.getString("accountId"));
                    account.setAccountHolderName(resultSet.getString("accountHolderName"));
                    account.setAccountType(resultSet.getString("accountType"));
                    account.setBalance(resultSet.getFloat("balance"));
                    account.setContactNumber(resultSet.getString("contactNumber"));
                    account.setAddress(resultSet.getString("address"));
                    account.setAccountCreatedDate(resultSet.getDate("accountCreatedDate").toLocalDate());
                    account.setDob(resultSet.getDate("dob").toLocalDate());
                    account.setAccountStatus(resultSet.getBoolean("accountStatus"));

                    return Optional.of(account);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }
    
    public List<Account> getAllAccounts()
    {
    	Optional<Connection> connection = DBUtils.getConnection();
    	 PreparedStatement preparedStatement = null;
         ResultSet resultSet = null;
         String query = "select * from account";
         List<Account> accounts = new ArrayList<>();
         if(connection.isPresent()) {
        	 try {
        		 preparedStatement = connection.get().prepareStatement(query);
        		 resultSet = preparedStatement.executeQuery();
        	 
        	 while(resultSet.next()) {
        		 Account account = new Account();
        		 account.setAccountId(resultSet.getString("accountId"));
        		 account.setDob(resultSet.getDate("dob").toLocalDate());
        		 accounts.add(account);
        	 }
        	 return accounts;
         } catch(SQLException e)
        	 {
        	 e.printStackTrace();
        	 }
    	
    }
		return null;
    }
    
	public boolean deleteAccount(String accountId)
	{
//		if(accountId.is)
		Optional<Connection> connection = DBUtils.getConnection();
	
		String query = "delete from account where accountID = ?";
		PreparedStatement preparedStatement = null;
		if(connection.isPresent())
		{
			try {
				preparedStatement.setString(1, accountId);
				preparedStatement = connection.get().prepareStatement(query);
				
				return true;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}
}
