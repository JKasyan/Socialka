package com.kasyan.Socialka.Services.Impl;

import java.util.Map;

import com.kasyan.Socialka.Dao.SignInDao;
import com.kasyan.Socialka.Services.SignInService;

public class SignInServiceImpl implements SignInService {
	
	private SignInDao signInDao;

	public void setSignInDao(SignInDao signInDao) {
		this.signInDao = signInDao;
	} 

	@Override
	public Map<Boolean, Object> signIn(String email, String password) {
		
		return signInDao.signIn(email, password);
	}

}
