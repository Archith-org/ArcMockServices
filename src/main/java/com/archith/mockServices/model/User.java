package com.archith.mockServices.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Component
@Entity
@Table(name = "Ubi_Users")
public class User {
	
	@Id
	@Column(name = "UserID")
	@SequenceGenerator(name = "id_sequence", sequenceName = "id_sequence", allocationSize = 5)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
	private int id;
	
	@Column(name = "User_Name")
	private String userName;
	
	@Column(name = "User_FirstName")
	private String firstName;
	
	@Column(name = "User_LastName")
	private String lastName;
	
	@Column(name = "User_Surname")
	private String surname;
	
	@Column(name = "User_Address")
	private String userAddress;
	
	@Column(name = "User_IsAdmmin")
	private boolean isAdmin;
	
	@Column(name = "User_Email")
	private String email;
	
	@Column(name = "User_Active")
	private char active;
	
	@Column(name = "User_PhoneNumber")
	private long phoneNumber;
	
	@Column(name = "User_Status")
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getActive() {
		return active;
	}

	public void setActive(char active) {
		this.active = active;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
