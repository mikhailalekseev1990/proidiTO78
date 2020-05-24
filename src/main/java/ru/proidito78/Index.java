package ru.proidito78;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class Index {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void sendMail(){
		if(message == null || message.equalsIgnoreCase("")){
			return;
		}
		final String to = "mail";
		final String from = "mail";
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(properties,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"mail", "password");
					}
				}); // default session

		try {
			MimeMessage mimeMessage = new MimeMessage(session); // email message
			mimeMessage.setFrom(new InternetAddress(from)); // setting header fields
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mimeMessage.setSubject("From mail"); // subject line

			// actual mail body
			mimeMessage.setText(message);

			// Send message
			Transport.send(mimeMessage);
			System.out.println("Email sent successfully....");

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}

	}
}