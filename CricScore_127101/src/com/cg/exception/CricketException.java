package com.cg.exception;

public class CricketException extends Exception{
	
	String message;
	
	public CricketException(String message)
	{
		this.message = message;
	}
	

	@Override
	public String getMessage()
	{
		return message;
	}

}
