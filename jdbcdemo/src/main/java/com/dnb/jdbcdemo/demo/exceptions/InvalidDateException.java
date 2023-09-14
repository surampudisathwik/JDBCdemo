package com.dnb.jdbcdemo.demo.exceptions;

public class InvalidDateException extends Exception {

	public InvalidDateException(String msg)
	{
		super(msg);
	}
	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}
}
