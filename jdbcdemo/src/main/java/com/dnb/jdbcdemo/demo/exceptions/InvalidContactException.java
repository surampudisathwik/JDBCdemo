package com.dnb.jdbcdemo.demo.exceptions;

public class InvalidContactException extends Exception{
	public InvalidContactException(String msg)
	{
		super(msg);
	}
	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	
}
}
