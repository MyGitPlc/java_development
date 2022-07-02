package com.dapy.assignment;

import java.util.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
/*import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;*/
import javax.mail.internet.MimeMessage;

public class RegisterSendEmail  {

   public static void main(String [] args) { 
	   
      // Recipient's email ID needs to be mentioned.
   //   String to = "abcd@gmail.com";
      String to = args[0];

      // Sender's email ID needs to be mentioned
    //  String from = "web@gmail.com";
      String from = args[1];

      // Assuming you are sending email from localhost
      String host = "localhost";

      // Get system properties
      Properties properties = System.getProperties();
      
      //properties.setProperty(host);

      // Setup mail server
      properties.setProperty("mail.smtp.host", host);

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);

      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("Re: Login Failed Attempts!");

         // Now set the actual message
         message.setText("Please try re-login, your account as been unlocked, your temporary password is: weLC12@$. Thanks");

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
	
}
