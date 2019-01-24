package com.bms.mail.bmsMailer.gateway;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMail {
	
	String emails[];	
	
	//http://localhost:8080/send/to?email=soumyadeeplogin@gmail.com+soumyadeeplogin@hotmail.com&hall=forumSujana&movie=Capt.Marvel&date=12.03.2019
	
	
	@RequestMapping(value = "/send/to", method = RequestMethod.GET)
	@ResponseBody
	
	public void getNotification(@RequestParam("email") String email, @RequestParam("hall") String hall, 
			@RequestParam("date") String date, @RequestParam("movie") String movie)
	{
		populateEmailList(email);
		System.out.println("Hall : " + hall);
		System.out.println("Date : " + date);
		System.out.println("Movie : " + movie);
		
		sendEmail("Ticket available for " + movie + " at " + hall + " on " + date);
	}
	
	public void populateEmailList(String email)
	{
		emails = email.split(" ");
		for (String emailID : emails) {
			System.out.println(emailID + " ");
		}
	}
	
	public void sendEmail(String emailBody)
	{
		
		/*final String username = "soumyadeeplogin@gmail.com";
		final String password = "czwoqehxwogdbbep";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");*/

		
		final String username = "soumyadeeplogin@hotmail.com";
		final String password = "levjlcnbatvvlkke";
		
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.live.com");
		props.put("mail.smtp.port", "587");
		
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		try{
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("soumyadeeplogin@hotmail.com"));
			
			for(int i = 0; i < emails.length; i++)
				message.addRecipients(Message.RecipientType.TO,
						InternetAddress.parse(emails[i]));

			message.setSubject("Movie Ticket Notification");
			message.setText(emailBody);
			Transport.send(message);
			
			System.out.println("Notified :: " + emailBody);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
