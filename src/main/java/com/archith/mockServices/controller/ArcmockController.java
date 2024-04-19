package com.archith.mockServices.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.archith.mockServices.constants.UbisagoConstants;
import com.archith.mockServices.model.User;
import com.archith.mockServices.security.UserDetails;
import com.archith.mockServices.service.UserService;
import com.archith.mockServices.to.OtpRequest;
import com.archith.mockServices.to.UserTo;
import com.archith.mockServices.util.EmailSender;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class ArcmockController {
	
	@Autowired
	private UserService userService;
	
	
	private UserDetails userDetails;
	
	
	
	@GetMapping(value = "/mockstatus")
	public static  String showserverStatus() {
		return "ARCENDOW Server started up and running..";
	}
	
	@GetMapping(value = {"/home","port",})
	public ModelAndView routeToHomePage(final HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = httpServletRequest.getSession();
		if(userDetails != null) {
		mav.addObject(userDetails.getEmail());
		mav.addObject(userDetails.getId());
		mav.addObject(userDetails.getUserName());
		mav.addObject(session.getMaxInactiveInterval());
		}
		else {
			mav.addObject(userDetails.getEmail() == "");
			mav.addObject(userDetails.getId()== 0);
			mav.addObject(userDetails.getUserName() == "");
			mav.addObject(session.getMaxInactiveInterval());
		}
		mav.setViewName("/"+httpServletRequest.getAttribute("redirectPath").toString());
		return mav;
		
	}
	
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	private UserTo authenticateUser(@RequestBody UserTo userTo) {
		//String userEmail = userTo.getUserEmail();
		int id = userTo.getUserId();
		userService.authenticateUser(id);
		return userTo;
	}
	
	@PostMapping(value = "/generateOtp")
	@ResponseBody
	public String generateOtp(@RequestBody OtpRequest otpRequestTo) {
		String email = otpRequestTo.getEmail();
		String name = otpRequestTo.getName();
		String generatedOTP = userService.generateOtp(email, name);
        return generatedOTP;
	}
	
	@PostMapping(value = "/verifyOtp")
	@ResponseBody
	public boolean validateOTP(@RequestBody OtpRequest otpverificationTO) {
		String email = otpverificationTO.getEmail();
		String enteredOTP = otpverificationTO.getEnteredOTP();
		System.out.println("VeriyOTP..." + "Email: " + email + "OTP: " + enteredOTP);
		return userService.validateOTP(email, enteredOTP);
	}

}
