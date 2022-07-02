package com.dapy.assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ObjectOperation {
	private String fileName;

	public static void main(String[] args) throws Exception {

		ObjectOperation obj = new ObjectOperation("C:\\Users\\dapto\\Desktop\\userRegister.txt");
		RegisterUserDetails user1 = new RegisterUserDetails("Dapo", "Solomon", "jd@mail.com", "parv", "123");
		RegisterUserDetails user2 = new RegisterUserDetails("Dapo1", "Solomon1", "jd@mail.com", "parv1", "123");
		RegisterUserDetails user3 = new RegisterUserDetails("Dapo2", "Solomon2", "jd@mail.com", "parv2", "123");

		//obj.writeFile(user1);
		//obj.writeFile(user2);
		//obj.writeFile(user3);
		List<RegisterUserDetails> outList = obj.readFile();
		System.out.println(outList);
		boolean dataFound = false;
		for (RegisterUserDetails detail:outList) {
			if (detail.getUserName().equals("tim") && detail.getPassword().equals("YeiJ92@$")) {
			dataFound = true;	
			break;
			}
		}
System.out.println("Data found "+dataFound);
	}

	public ObjectOperation(String fileName) {
		this.fileName = fileName;
	}

	public void writeFile(RegisterUserDetails user) {
		try {
			String fileName = this.fileName;
			FileOutputStream f = new FileOutputStream(fileName, true);
			if (new File(fileName).length() == 0) {
				ObjectOutputStream o = new ObjectOutputStream(f);
				o.writeObject(user);
				o.close();
			} else {
				MyOutputStream myOutputStream = new MyOutputStream(f);
				myOutputStream.writeObject(user);
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

	public List<RegisterUserDetails> readFile()
			throws FileNotFoundException, IOException, ClassNotFoundException {
		List<RegisterUserDetails> ud1 = new ArrayList<>();
		try {
			String fileWithPath = this.fileName;
			FileInputStream fi = new FileInputStream(fileWithPath);
			ObjectInputStream oi = new ObjectInputStream(fi);
			if (oi != null) {
				while (true) {
					try {
						RegisterUserDetails data = (RegisterUserDetails) oi.readObject();
						if (data != null)
							ud1.add(data);
					} catch (EOFException eof) { // eof.printStackTrace();
						System.out.println("EOF reached");
						break;
					}
				}
			}
			oi.close();
			fi.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream " + e);

		} catch (ClassNotFoundException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ud1;
	}

}
