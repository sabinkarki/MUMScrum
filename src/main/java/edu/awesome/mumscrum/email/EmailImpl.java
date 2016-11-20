/**
 * 
 */
package edu.awesome.mumscrum.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * @author sabin
 *
 */
@Service
public class EmailImpl implements Email {
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendEmail(String to, String subject, String body) {
		
		MimeMessage message=mailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper=new MimeMessageHelper(message,true);
			helper.setSubject(subject);
			helper.setTo(to);
			helper.setText(body,true); //true indicates we can provide html tags in body
			mailSender.send(message);// true indicates multipart message
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}


	}

