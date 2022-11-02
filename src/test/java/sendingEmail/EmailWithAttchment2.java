package sendingEmail;

import java.io.File;

import javax.mail.internet.InternetAddress;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;

public class EmailWithAttchment2 {
	
	String[] to={"arynadevi@gmail.com","vishalkr1091@gmail.com","vishalkr.automation@gmail.com"};

	@Test(enabled=false, description="Send multiple attachment")
	public void f2() throws EmailException, Exception{
		File fileScreenshot = new File("C:\\Users\\vishalkumar\\Desktop\\Oct Bill\\FaveoAutomationTestReport (1).html");
	    EmailAttachment attachment = new EmailAttachment();
	    attachment.setPath(fileScreenshot.getPath());
	    attachment.setDisposition(EmailAttachment.ATTACHMENT);
	    attachment.setDescription("Attachment");
	    attachment.setName(fileScreenshot.getName());

	    File fileLogs = new File(".\\TestReport\\Rose.jpeg");
	    EmailAttachment attachmentLogs = new EmailAttachment();
	    attachmentLogs.setPath(fileLogs.getPath());
	    attachmentLogs.setDisposition(EmailAttachment.ATTACHMENT);
	    attachmentLogs.setDescription("Logs");
	    attachmentLogs.setName(fileLogs.getName());
	    
	    File fileLogs1 = new File("C:\\Users\\vishalkumar\\Desktop\\Oct Bill\\FaveoAutomationTestReport (2).html");
	    EmailAttachment attachmentLogs1 = new EmailAttachment();
	    attachmentLogs1.setPath(fileLogs1.getPath());
	    attachmentLogs1.setDisposition(EmailAttachment.ATTACHMENT);
	    attachmentLogs1.setDescription("Logs");
	    attachmentLogs1.setName(fileLogs1.getName());

		  // Create the email message
		  MultiPartEmail email = new MultiPartEmail();
		  email.setHostName("smtp.gmail.com");
		  email.addTo("arynadevi@gmail.com");
		  email.setFrom("vishalkr.demo@gmail.com");
		  
		email.setAuthenticator(new DefaultAuthenticator("vishalkr.demo@gmail.com", "Automation@321"));
		//email.setSmtpPort(465);
		email.setSSLOnConnect(true);
		 
		  email.setSubject("The picture");
		  email.setMsg("Here is the picture you wanted");

		  // add the attachment
		  email.attach(attachment);
		  email.attach(attachmentLogs);
		  email.attach(attachmentLogs1);
		

		  // send the email
		  email.send();
	}
	
	
	@Test(enabled=true, description="send multiple attachment with multiple recipients")
	public void f3() throws EmailException, Exception{
		File fileScreenshot = new File("C:\\Users\\vishalkumar\\Desktop\\ZipExample\\Zip1.zip");
		//File fileScreenshot = new File(System.getProperty("user.dir")+"/FileFolder/Demo.txt");
	    EmailAttachment attachment = new EmailAttachment();
	    attachment.setPath(fileScreenshot.getPath());
	    attachment.setDisposition(EmailAttachment.ATTACHMENT);
	    attachment.setDescription("Attachment");
	    attachment.setName(fileScreenshot.getName());

		  // Create the email message
		  MultiPartEmail email = new MultiPartEmail();
		  email.setHostName("smtp.gmail.com");
		  
		    
		  for ( String address : to) {
				System.out.println(address);
			  email.addTo(address);
			}
		   
		 // email.addTo("arynadevi@gmail.com");
		 
		  email.setFrom("vishalkr.demo@gmail.com");
		  
		email.setAuthenticator(new DefaultAuthenticator("vishalkr.demo@gmail.com", "Automation@321"));
		//email.setSmtpPort(465);
		email.setSSLOnConnect(true);
		 
		  email.setSubject("Multiple Attachment with Multiple recipents");
		  email.setMsg("Sending Email Through Java Code");

		  // add the attachment
		  email.attach(attachment);
		
		  // send the email
		  email.send();
	}
}
