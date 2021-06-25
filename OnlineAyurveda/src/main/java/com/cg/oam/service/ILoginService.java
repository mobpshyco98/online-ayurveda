package com.cg.oam.service;

import java.util.Map;



import com.cg.oam.entities.Login;
import com.cg.oam.exceptions.LoginException;

/*
 * Created By Titas Sarkar
 */
public interface ILoginService {
	
	public Login doLogin(Integer userId, String password) throws LoginException;
	public String encryptString(String str);
	public String decryptString(String str);
	public String encryptLogin(Login loginAcnt);
	public String generateToken(Login login);
	public Map<String, Login> getAuthMap();
	public boolean verifyLogin(String tokenId) throws LoginException;
}
