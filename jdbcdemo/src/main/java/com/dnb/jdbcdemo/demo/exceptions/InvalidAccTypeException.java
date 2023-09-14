package com.dnb.jdbcdemo.demo.exceptions;

public class InvalidAccTypeException extends Exception{
	public InvalidAccTypeException(String msg)
	{
		super(msg);
	}
	@Override
	public String toString() {
		return super.toString()+super.getMessage();

}
}
