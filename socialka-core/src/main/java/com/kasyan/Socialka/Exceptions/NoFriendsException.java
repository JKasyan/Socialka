package com.kasyan.Socialka.Exceptions;

public class NoFriendsException extends Exception {
	
private static final long serialVersionUID = 1L;
	
	public NoFriendsException(String email){
		super("User with email = "+email+" not found.");
	}
}
