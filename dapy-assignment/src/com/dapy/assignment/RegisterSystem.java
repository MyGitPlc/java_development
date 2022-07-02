package com.dapy.assignment;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.Console;
import com.dapy.assignment.RegisterSendEmail;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.Timestamp;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;
import java.util.stream.Collectors;

public class RegisterSystem {

//	RegisterUserDetails regDets = new RegisterUserDetails();
	private Timestamp time;
	Properties prop = new Properties();

	public void RegisterNormalPassword(String action) throws IOException, ClassNotFoundException {

		Console console = System.console();
		String password = "";
		String mfirstName, mlastName, memailId;
		// List recFound = null;
		boolean pass1Ok, pass2Ok, nameChecked;
		boolean checkEmail;

		if (console == null) {
			System.out.println("No console available");
			return;
		}
		pass1Ok = true;
		// while (pass1Ok) {

		pass2Ok = true;

		// while (pass2Ok) {
		String firstName;
		nameChecked = false;
		while (nameChecked) {
			System.out.print("Enter First Name: ");
			 firstName = console.readLine(); // Accept user first name

			nameChecked = checkName(firstName);
			// String firstName = "Dapo"; // Accept user first name
			System.out.println("Name check is "+ nameChecked);
		} ;
//mfirstName = firstName;

		System.out.println();
		String lastName;
		do {
			System.out.print("Enter Last Name: ");

			lastName = console.readLine(); // Accept user last name
			nameChecked = checkName(lastName);
			// String lastName = "Shitu"; // Accept user last name
		} while (nameChecked = false);

		String emailId;
		do {
			System.out.print("Enter your email: ");
			emailId = console.readLine(); // Accept user last name
			checkEmail = checkEmailId(emailId);
		} while (checkEmail = false);

		// String emailId = "daptona@yahoo.com"; // Accept user last name

		// Read line
		String userName = console.readLine("Enter username : ");

		// String userName = "dap";

		try {
			List<RegisterUserDetails> recFound = readRegisteredUserInfo(firstName, lastName, emailId, userName, null);

			// if (recFound == null) {
			if (recFound.isEmpty()) {
				/*
				 * Readpassword into character array
				 * 
				 */
				char[] ch = null;
				boolean pass3Ok = true;
				while (pass3Ok) {

					ch = console.readPassword("Enter password : ");
					// Runtime.getRuntime().exec("cls");

					if (ch.length < 8) {

						System.out.println("Password must not be less than 8 characters");
						ch = null;
						continue;
					}

					// password = ch.toString();
					password = new String(ch);

					// password = "SituG#12";
					pass3Ok = false;

				} // while (pass3Ok = true);

				RegisterUserDetails userData = new RegisterUserDetails(firstName, lastName, emailId, userName,
						password);

				// Print password
				writeUserInfo(userData);

				String usrData = firstName + "," + lastName + "," + emailId + "," + userName + "," + password;
				writeUserInfo1(usrData);

				String usrData1 = firstName + "," + lastName + "," + emailId + "," + userName + "," + password + ","
						+ action + "," + Time.from(Instant.now());
				writeFileHistory(usrData1);
		//		break;
			} else {

			System.out.println("User info provided already exist, please use the Login option");
			}
		//	break;
		} catch (IOException io) {

		}
		// } // while (pass2Ok = true);

//		break;
	} // while (pass1Ok = true);

	//return;

	//}

	public void RegisterComplexPassword(String action) throws IOException, ClassNotFoundException { // minimum 8 xter
																									// length, 1 cap
		// letter, 1 small, 1
		// special xter, 1 number
		Console console = System.console();
		// boolean pass1Ok;
		boolean pass2Ok;
		// String userPassword = "";
		String password = "";
		Character passwdXter;
		int iDigit = 0;
		int iUpper = 0;
		int iLower = 0;
		int iSpecial = 0;

		if (console == null) {
			System.out.println("No console available");
			return;
		}

		// do {

		pass2Ok = false;
		System.out.print("Enter First Name: ");
		String firstName = console.readLine(); // Accept user first name
		// String firstName = "Giringori";
		// checkName(firstName);

		System.out.println();

		System.out.print("Enter Last Name: ");
		String lastName = console.readLine(); // Accept user last name

		// String lastName = "Jogologbo";
		// Read line - username
		String userName = console.readLine("Enter username : "); // Accept username
		// String userName = "giri";
		// Read line - email
		String emailId = console.readLine("Enter your email : "); // Accept username
		// String emailId = "girinj@yahoo.com";
		try {
			List<RegisterUserDetails> recFound = readRegisteredUserInfo(firstName, lastName, emailId, userName, null);

			// if (recFound == null) {
			if (recFound.isEmpty()) {

				// Read password
				// into character array
				// minimum 8 xter length, 1 cap letter, 1 small, 1 special xter, 1 number
				// boolean pass1Ok = false;
				boolean passOk = true;

				while (passOk) {
					iDigit = 0;
					iUpper = 0;
					iLower = 0;
					iSpecial = 0;
					char[] ch = null;
					passwdXter = null;

					ch = console.readPassword("Enter password : ");

					/// String ch = "hJuY01&)";

					if (ch.length < 8) {

						System.out.println("Password must not be less than 8 characters");
						// passOk = false;
						ch = null;
						continue;
					}

					// String passwdXter1 = ch.toString();

					String passwdXter1 = new String(ch);
					int j = 0;
					for (int i = 0; i < ch.length; i++) {

						passwdXter = passwdXter1.charAt(i);
						System.out.println();
						System.out.println(passwdXter);
						j = i;
						// if (passwdXter.isDigit()) {
						if (Character.isDigit(passwdXter)) {
							System.out.println();
							System.out.println(passwdXter);
							iDigit++;
							if (iDigit > 2) {

								System.out.println("You cannot have more than " + iDigit + " digit, pls re-enter");
								// passOk = true;
								j = i;

								break;
							}
						}

						if (Character.isUpperCase(passwdXter)) {

							iUpper++;
							if (iUpper > 2) {
								System.out.println(
										"You cannot have more than " + iUpper + " Uppercase charater, pls re-enter");
								// passOk = true;
								j = i;

								break;
							}
						}

						if (Character.isLowerCase(passwdXter)) {
							iLower++;
							if (iLower > 2) {
								System.out.println(
										"You cannot have more than " + iLower + " Lowercase charater, pls re-enter");
								// passOk = true;
								j = i;

								break;
							}
						}

						if (passwdXter.toString().matches(RegisterProperty.getProperty("specialXter"))) {

							iSpecial++;
							if (iLower > 2) {
								System.out.println(
										"You cannot have more than " + iSpecial + " Lowercase charater, pls re-enter");
								// passOk = true;
								j = i;

								break;
							}
						}
						password = password + passwdXter.toString();
					}

					if (j < ch.length - 1) {
						// passOk = true;
						ch = null;
						continue;
					}
					passOk = false;

				}
				// while (pass1Ok = false);

				RegisterUserDetails userData = new RegisterUserDetails(firstName, lastName, emailId, userName,
						password);
				// Print password
				writeUserInfo(userData);

				String usrData = firstName + "," + lastName + "," + emailId + "," + userName + "," + password;
				writeUserInfo1(usrData);

				String usrData1 = firstName + "," + lastName + "," + emailId + "," + userName + "," + password + ","
						+ action + "," + Time.from(Instant.now());
				writeFileHistory(usrData1);
				return;
			}

			System.out.println("User Already exist, use the login option");
			// break;

		} catch (IOException io) {

		}

		// } while (pass2Ok);
		return;
	}

	public boolean checkName(String name) {

		int letterCnt = name.length();

		for (int i = 0; i < letterCnt; i++) {

			if (!Character.isLetter(name.charAt(i))) {
				System.out.println("You just input an invalid "+ name+" , pls re-enter");
				return false;
			
			} 
			
		}

		return true;
	}

	public boolean checkEmailId(String emailId) {
		// boolean containsAtId;
		if (emailId.contains("@")) {

			return true;
		} else {
			System.out.println("You just input an invalid "+ emailId +" , pls re-enter");
			return false;
		}
	}

	public void writeUserInfo(RegisterUserDetails userData) {

		try {
			String fileName = RegisterProperty.getProperty("userRegister");
			// Path path = Paths.get(RegisterProperty.getProperty("userRegister"));
			FileOutputStream f = new FileOutputStream(fileName, true);
			if (new File(fileName).length() == 0) {
				ObjectOutputStream o = new ObjectOutputStream(f);
				o.writeObject(userData);
				o.close();
			} else {
				MyOutputStream myOutputStream = new MyOutputStream(f);
				myOutputStream.writeObject(userData);
				myOutputStream.close();
			}

			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream " + e);
			e.printStackTrace();
		}
	}

	public void writeUserInfo1(String usrData) {

		try {

			Path path = Paths.get(RegisterProperty.getProperty("userRegister1")); // to store input

			BufferedWriter bw = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND);

			PrintWriter pw = new PrintWriter(bw);
			bw.write(usrData);
			bw.newLine(); // pw.write(rec);
			bw.flush();
			bw.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
	}

	public void writeFileHistory(String usrData1) {
		try {

			Path path = Paths.get(RegisterProperty.getProperty("userDetails"));
			BufferedWriter bw = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND);

			PrintWriter pw = new PrintWriter(bw);
			bw.write(usrData1);
			bw.newLine(); // pw.write(rec);
			bw.flush();
			bw.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream " + e);
			e.printStackTrace();

		}
	}

	public List<RegisterUserDetails> readRegisteredUserInfo(String firstName, String lastName, String emailId,
			String userName, String userpassword) throws FileNotFoundException, IOException, ClassNotFoundException {
		List<RegisterUserDetails> ud1 = new ArrayList<>();

		try {
			// String fileName = RegisterProperty.getProperty("userRegister");

			File f = new File(RegisterProperty.getProperty("userRegister"));

			if (f.length() == 0) {

				return null;

			} else {

				ObjectOperation obj = new ObjectOperation(RegisterProperty.getProperty("userRegister"));
				List<RegisterUserDetails> list = obj.readFile();

				for (RegisterUserDetails data : list) {
					if (userName.equalsIgnoreCase(data.getUserName()) && emailId.equalsIgnoreCase(data.getEmailId())) {
						ud1.add(data);
						break;
					} else {
						if (firstName.equalsIgnoreCase(data.getFirstName())
								&& lastName.equalsIgnoreCase(data.getLastName())
								&& userName.equalsIgnoreCase(data.getFirstName())
								&& emailId.equalsIgnoreCase(data.getEmailId())) {
							ud1.add(data);
							break;
						}
					}

				}

			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			// System.out.println("Error initializing stream " + e);
			System.out.println(e);

		} catch (ClassNotFoundException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ud1;
	}

	public List<RegisterUserDetails> readRegisterInfoToLogin(String firstName, String lastName, String emailId,
			String userName, String action, String userpassword)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		List<RegisterUserDetails> ud1 = new ArrayList<>();

		try {
			// String fileName = RegisterProperty.getProperty("userRegister");

			File f = new File(RegisterProperty.getProperty("userRegister"));

			if (f.length() == 0) {

				return null;

			} else {

				// FileInputStream fi = new
				// FileInputStream(RegisterProperty.getProperty("userRegister"));
				FileInputStream fi = new FileInputStream(f);
				ObjectInputStream oi = new ObjectInputStream(fi);
				if (oi != null) {
					while (true) {
						try {
							RegisterUserDetails data = (RegisterUserDetails) oi.readObject();
							if (data != null) {
								if (userName.equalsIgnoreCase(data.getUserName())
										&& userpassword.equalsIgnoreCase(data.getPassword())) {
									ud1.add(data);
									break;
								}
								if (userName.equalsIgnoreCase(data.getUserName())) {
									ud1.add(data);
									break;
								}
								if (userpassword.equalsIgnoreCase(data.getPassword())) {
									ud1.add(data);
									break;
								}
							}
							// }
							// }
							// ud1.add(data);
						} catch (EOFException eof) {
							// eof.printStackTrace();
							System.out.println("EOF reached");
							break;
						}
					}
				}
				oi.close();
				fi.close();
			}
		} catch (FileNotFoundException e) {

			System.out.println("File not found");
		} catch (IOException e) {
			// System.out.println("Error initializing stream " + e);
			System.out.println(e);

		} catch (ClassNotFoundException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Dapo " + ud1);
		return ud1;
	}

	public void loginUser(String action) throws Exception {

		// Console console = System.console();
		Calendar cal = Calendar.getInstance();

		int attemptCnt = 1;

		Date d1 = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyy hh:mm:ss");

		// Read line - username
		boolean passok = true;
		do {
			// String userName = console.readLine("Enter your username : "); // Accept
			// username

			String userName = "dap";
			// Read password
			// into character array
			// minimum 8 xter length, 1 cap letter, 1 small, 1 special xter, 1 numbe
			// char[] ch = console.readPassword("Enter your password : ");

			String ch = "Uh28js&";
			// List<String> result = readPassword(userName, ch.toString());

			List<RegisterUserDetails> result = readRegisterInfoToLogin(null, null, null, userName, null, ch);

			if (!result.isEmpty()) {

				boolean userNameFound = checkAfter24hrs(result);
				if (userNameFound == true) {
					passok = false;
					break;
				}
				// }

				if ((userName.equalsIgnoreCase(result.get(0).getUserName())
						&& ch.equalsIgnoreCase(result.get(0).getPassword()))) {

					System.out.println("Your login is successful: ");
					System.out.println("Your firstName: " + result.get(0).getFirstName());
					System.out.println("Your lastName: " + result.get(0).getLastName());
					System.out.println("Your emailId: " + result.get(0).getEmailId());
					passok = false;
					break;
				} else if ((userName.equalsIgnoreCase(result.get(0).getUserName()) && result.get(0).getPassword() != ch)
						|| (result.get(0).getUserName() != userName
								&& ch.equalsIgnoreCase(result.get(0).getPassword()))) {
					System.out.println("Your password or username is not correct, pls re-enter");

					attemptCnt++;
				} /*
					 * else {
					 * System.out.println("Please you need to register before you can login"); }
					 */

				if (attemptCnt > Integer.parseInt(RegisterProperty.getProperty("passwdCnt"))) {
					String emailId = result.get(0).getEmailId();
					UserLoginFailedAttempts userData1 = new UserLoginFailedAttempts(userName, emailId);

					// userData1.getUserName();
					// userData1.getTime();
					writeFailedLoginAttempts(userData1);
					System.out.println("You have failed 3 attempts");
					passok = false;
					break;
				}
			} else {

				System.out.println("Please you need to register before you can login, thanks.");
				passok = false;
				break;
			}
			continue;
		} while (passok);

	}

	public boolean checkAfter24hrs(List<RegisterUserDetails> result) throws Exception, IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String userName = result.get(0).getUserName();

		List<UserLoginFailedAttempts> failedAttemptData = readFailedAttemptFile(userName);

		if (!failedAttemptData.isEmpty()) {
			java.sql.Timestamp timeAttemptFailed = failedAttemptData.get(0).getTime();

			java.sql.Timestamp time2 = java.sql.Timestamp.from(Instant.now());

			int time1 = time2.toLocalDateTime().getHour();
			int time3 = timeAttemptFailed.toLocalDateTime().getHour();

			Duration diffInTime = Duration.ofHours(time3);
			// long diffInTime1 = time1 - time3;
			long diffInTime1 = 25;

			if (diffInTime1 <= 24) {
				System.out.println("You cannot login until after 24 hrs");
				return true;
			} else {
				if (!failedAttemptData.isEmpty() && diffInTime1 > 24) {
					String fromEmail = RegisterProperty.getProperty("fromEmail");
					String toEmail = result.get(0).getEmailId();
					String[] emailParam = { toEmail, fromEmail };
					RegisterSendEmail.main(emailParam);
					removeLine(failedAttemptData);
					return true;
				}

			}
		}
		return false;
	}

	public List<UserLoginFailedAttempts> readFailedAttemptFile(String userName)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		List<UserLoginFailedAttempts> ud1 = new ArrayList<>();

		try {
			// String fileName = RegisterProperty.getProperty("userRegister");

			File f = new File(RegisterProperty.getProperty("failedAttemptLog"));

			if (f.length() == 0) {

				return null;

			} else {

				FileInputStream fi = new FileInputStream(f);
				ObjectInputStream oi = new ObjectInputStream(fi);
				if (oi != null) {
					while (true) {
						try {
							UserLoginFailedAttempts data = (UserLoginFailedAttempts) oi.readObject();
							if (data != null) {
								if (userName.equalsIgnoreCase(data.getUserName())) {
									ud1.add(data);
									break;
								}

								else {
								}
							}
							// ud1.add(data);
						} catch (EOFException eof) {
							// eof.printStackTrace();
							System.out.println("EOF reached");
							break;
						}
					}
				}
				oi.close();
				fi.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			// System.out.println("Error initializing stream " + e);
			System.out.println(e);

		} catch (ClassNotFoundException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ud1;
	}

	public void writeFailedLoginAttempts(UserLoginFailedAttempts userData) {

		try {
			String fileName = RegisterProperty.getProperty("failedAttemptLog");
			// Path path = Paths.get(RegisterProperty.getProperty("userRegister"));
			FileOutputStream f = new FileOutputStream(fileName, true);
			if (new File(fileName).length() == 0) {
				ObjectOutputStream o = new ObjectOutputStream(f);
				o.writeObject(userData);
				o.close();
			} else {
				MyOutputStream myOutputStream = new MyOutputStream(f);
				myOutputStream.writeObject(userData);
				myOutputStream.close();
			}

			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream " + e);
			e.printStackTrace();

		}
	}

	public void removeLine(List<UserLoginFailedAttempts> failedAttemptData) throws IOException {
		File file = new File(RegisterProperty.getProperty("failedAttemptLog"));
		List<String> out = Files.lines(file.toPath()).filter(line -> !line.contains((CharSequence) failedAttemptData))
				.collect(Collectors.toList());
		Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
	}

}
