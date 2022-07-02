package com.dapy.assignment;

import java.sql.Timestamp;
import java.time.Instant;
import java.io.Serializable;

public class RegisterUserDetails implements Serializable{

	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private String emailId;
	private String userName;
	private String password;
	private String action;
	private Timestamp time;

	public RegisterUserDetails(String firstName, String lastName, String emailId, String userName, String password) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.userName = userName;
		this.password = password;
	//	this.action = action;
		this.time = Timestamp.from(Instant.now());
		;
	}

	/*
	 * public static long getSerialversionuid() { return serialVersionUID; }
	 */

	public RegisterUserDetails() {
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getAction() {
		return action;
	}

	public Timestamp getTime() {
		return time;
	}
	
	@Override
	public String toString() {
		return "UserDetails{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", action='" + action + '\'' +
                ", time=" + time +
                '}';
	}

}
