package com.archith.mockServices.service;

import com.archith.mockServices.to.OtpRequest;
import com.archith.mockServices.to.UserTo;

public interface UserService {
	
	public UserTo authenticateUser(int userEmail);

	public String generateOtp(String email, String name);

	public boolean validateOTP(String userEmail, String userOtp);

}
