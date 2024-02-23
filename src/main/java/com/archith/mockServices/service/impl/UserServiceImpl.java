package com.archith.mockServices.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.archith.mockServices.constants.UbisagoConstants;
import com.archith.mockServices.daoRepository.UserDao;
import com.archith.mockServices.service.UserService;
import com.archith.mockServices.to.OtpRequest;
import com.archith.mockServices.to.UserTo;
import com.archith.mockServices.util.EmailSender;


@Service
@EnableJpaRepositories
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private EmailSender emailSender;
	
	private static Map<String, String> inMemoryOtpMap = new ConcurrentHashMap<>();
	
	@Override
	public UserTo authenticateUser(int userId) {
		UserTo userTo = new UserTo();
		List li = userDao.findAll();
		List<UserTo> lid = li;
		if(li != null) {
			for(UserTo ut : lid) {
				userTo.setUserEmail(ut.getUserEmail());
				userTo.setUserName(ut.getUserName());
			}
			System.out.println("Users List: " + li.toString());
		}
		
		return userTo;
	}

	@Override
	public String generateOtp(String email, String name) {
		String numbers = UbisagoConstants.OTP_REQUEST_NUMBERS;
		int otpLength = UbisagoConstants.OTP_LENGTH;
        Random random = new Random();
        StringBuilder otp = new StringBuilder(otpLength);
        
        for (int i = 0; i < otpLength; i++) {
            otp.append(numbers.charAt(random.nextInt(numbers.length())));
        }
        String generatedOTP = otp.toString();
        inMemoryOtpMap.put(email, generatedOTP);
        System.out.println("Generated OTP: " + generatedOTP);
        emailSender.sendOtpViaEmail(email, generatedOTP,name);
		return generatedOTP;
	}
	
	public boolean validateOTP(String UserEmail, String userOtp) {
		String enteredOtp = userOtp;
		String email = UserEmail;
		String storedOtp = inMemoryOtpMap.get(email);
		return storedOtp != null && storedOtp.equals(enteredOtp);
	}


	

	
}
