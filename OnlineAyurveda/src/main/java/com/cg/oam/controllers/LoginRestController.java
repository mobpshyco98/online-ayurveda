package com.cg.oam.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oam.dto.LoginDto;
import com.cg.oam.dto.LoginResponse;
import com.cg.oam.dto.SuccessMessage;
import com.cg.oam.entities.Login;
import com.cg.oam.exceptions.LoginException;
import com.cg.oam.exceptions.ValidateUserException;
import com.cg.oam.service.ILoginService;
import com.cg.oam.util.LoginConstants;


@RestController
public class LoginRestController {

	@Autowired
	private ILoginService service;
	
	Logger logger=LoggerFactory.getLogger(LoginRestController.class);
	
	/*
	 * Controller Method for Login
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("login")
	public LoginResponse doLoginController(@Valid @RequestBody LoginDto logindto, BindingResult br) throws LoginException, ValidateUserException
	{
		
		if(br.hasErrors())
			throw new ValidateUserException(br.getFieldErrors());
		Login login=service.doLogin(logindto.getCustomerId(), logindto.getPassword());
		LoginResponse response= new LoginResponse();
		response.setToken(service.generateToken(login));
		response.setUserName(login.getUserName());
		response.setRole(login.getRole());
		return response;
	}
	
	/*
	 * Controller method for logging out
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="logout")
	public SuccessMessage logout(@RequestHeader("token-id") String token, HttpServletRequest req) {
		service.getAuthMap().remove(token);
		return new SuccessMessage(LoginConstants.LOGGED_OUT);
	}

}
