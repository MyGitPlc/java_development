package com.dapy.assignment;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.io.File;
import java.io.Serializable;
import java.nio.file.Files;

public class UserLoginFailedAttempts implements Serializable{

		private static final long serialVersionUID = 1L;

		
		private String userName;
		private String emailId;
		private Timestamp time;

		public UserLoginFailedAttempts(String userName, String emailId) {

			this.userName = userName;
			this.emailId = emailId;
			this.time = Timestamp.from(Instant.now());
			;
		}

		/*
		 * public static long getSerialversionuid() { return serialVersionUID; }
		 */

		public UserLoginFailedAttempts() {
			// TODO Auto-generated constructor stub
		}

			
		public String getUserName() {
			return userName;
		}
		public String EmailId() {
			return emailId;
		}

	 
		public Timestamp getTime() {
			return time;
		}
		
		public String setUsername(String userName) {
			return this.userName = userName;
		}
		
		
		@Override
		public String toString() {
			return "UserLoginFailedAttempts{" +
	                "userName='" + userName + '\'' +
	                ", time=" + time +
	                '}';
		}

	}


