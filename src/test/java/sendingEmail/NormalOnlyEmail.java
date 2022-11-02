package sendingEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;

public class NormalOnlyEmail {

	
	@Test
	public void f() throws EmailException{
		System.out.println("Starting Sending Mail");
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		//email.setSmtpPort(465);
		//Oct 2022  -> Used app password instead of gmail password (itffhraupvhilcpr)
		//Gmail password - Automation@321
		email.setAuthenticator(new DefaultAuthenticator("vishalkr.demo@gmail.com", "itffhraupvhilcpr"));
		email.setSSLOnConnect(true);
		email.setFrom("vishalkr.demo@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("arynadevi@gmail.com");
		email.send();
		
		System.out.println("Mail Sent Successfully");
	}
}
