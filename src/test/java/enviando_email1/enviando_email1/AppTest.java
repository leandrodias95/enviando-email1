package enviando_email1.enviando_email1;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{	
	private String userName="testemailleandro@gmail.com";
	private String password="ddcanvhahbmcdpgl"; 
	
	@org.junit.Test
   public void tesEmail() {
		try{
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		Session session = Session.getInstance(properties, new  Authenticator() {
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(userName, password);
		}

		});
		Address[]toUser = InternetAddress.parse("leandrobatista192@gmail.com");
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName));
		message.setRecipients(Message.RecipientType.TO, toUser);
		message.setSubject("Apenas um teste");
		message.setText("Foi apenas um teste");
		Transport.send(message);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
    
}
