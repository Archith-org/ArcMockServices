package com.archith.mockServices.util;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

import com.archith.mockServices.constants.UbisagoConstants;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

@Component
public class EmailSender {
	
	public static void sendOtpViaEmail(String toEmail, String otp, String name) {

        // Set up properties for the mail server
        Properties properties = new Properties();
        properties.put(UbisagoConstants.SMTP_AUTH, "true");
        properties.put(UbisagoConstants.SMTP_START_TLS, "true");
        properties.put(UbisagoConstants.SMTP_SSL_PROTOCOLS, "TLSv1.2");
        properties.put(UbisagoConstants.SMTP_SSL_TRUST, "smtp.gmail.com");
        properties.put(UbisagoConstants.EMAIL_SMTP_HOST, UbisagoConstants.EMAIL_HOST);
        properties.put(UbisagoConstants.EMAIL_SMTP_PORT, UbisagoConstants.EMAIL_PORT);

        // Get the Session object
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(UbisagoConstants.FROM_EMAIL, UbisagoConstants.EMAIL_APP_PASSKEY);
            }
        });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);

            // Set the sender and recipient email addresses
            try {
				message.setFrom(new InternetAddress(UbisagoConstants.FROM_EMAIL, UbisagoConstants.EMAIL_REF_NAME));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            String validToEmail = isValidEmail(toEmail.trim());
            if(validToEmail != null) {
            	message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(validToEmail));
            }
            

            // Set the email subject and content
            message.setSubject("Profile registration verification");
            message.setText("Hello " + name+", " + "Your OTP for ArcMock Test profile registration is: " + otp);
            // Send the message
            System.out.println("Email Message: " + message.toString());
            Transport.send(message);

            System.out.println("OTP sent successfully to " + toEmail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
	
	public static String isValidEmail(String email) {
		//String emailRecpt = email.substring(email.indexOf(":") + 2, email.lastIndexOf("\""));
        try {
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();
            System.out.println("Valid Email");
            return email;
        } catch (AddressException e) {
        	System.out.println("In-Valid Email");
            return null;
        }
    }


}
