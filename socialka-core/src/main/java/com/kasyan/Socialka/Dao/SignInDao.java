package com.kasyan.Socialka.Dao;

import java.util.Map;

public interface SignInDao {
	public Map<Boolean, Object> signIn(String email, String password);
}
