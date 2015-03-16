package com.kasyan.Socialka.Services;

import java.util.Map;

public interface SignInService {
	public Map<Boolean, Object> signIn(String email, String password);
}
