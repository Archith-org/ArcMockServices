package com.archith.mockServices.security;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("rawTypes")
public interface UserDetails extends Serializable{
	
	

	public int getId();

	public void setId(int id);

	public String getUserName();
	public void setUserName(String userName);

	public String getFirstName();

	public void setFirstName(String firstName);

	public String getLastName();

	public void setLastName(String lastName);

	public String getSurname();

	public void setSurname(String surname);

	public String getUserAddress();

	public void setUserAddress(String userAddress);

	public boolean isAdmin();

	public void setAdmin(boolean isAdmin);

	public String getEmail();

	public void setEmail(String email);

	public char getActive();
	public void setActive(char active);

	public long getPhoneNumber();

	public void setPhoneNumber(long phoneNumber);

	public String getStatus();

	public void setStatus(String status);
	

}
